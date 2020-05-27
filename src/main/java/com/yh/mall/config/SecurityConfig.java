package com.yh.mall.config;

import com.yh.mall.component.JwtAuthenticationTokenFilter;
import com.yh.mall.component.RestAuthenticationEntryPoint;
import com.yh.mall.component.RestfulAccessDeniedHandler;
import com.yh.mall.dto.AdminUserDetails;
import com.yh.mall.mgb.model.UmsAdmin;
import com.yh.mall.mgb.model.UmsPermission;
import com.yh.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @author YangHao
 * @ClassName: SecurityConfig
 * @Description: SpringSecurity 配置
 * @date 2020/5/27 12:07
 * @Version V1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UmsAdminService umsAdminService ;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                   .sessionManagement() //基于token，所以不需要session
                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                   .and()
                   .authorizeRequests()
                   .antMatchers(HttpMethod.GET,//允许对于网站静态资源的无授权访问
                           "/",
                           "/*.html",
                           "/favicon.ico",
                           "/**/*.html",
                           "/**/*.css",
                           "/**/*.js",
                           "/swagger-resources/**",
                           "/v2/api-docs/**"
                           )
                   .permitAll()
                   .antMatchers("/admin/login", "/admin/register")// 对登录注册要允许匿名访问
                   .permitAll()
                   .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                   .permitAll()
                   //.antMatchers("/**")//测试时全部运行访问
                   //.permitAll()
                   .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                   .authenticated();
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            UmsAdmin admin = umsAdminService.getAdminByUserName(username);
            if (admin != null) {
                List<UmsPermission> permissionList = umsAdminService .getPermissionList(admin.getId());
                return new AdminUserDetails(admin,permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
