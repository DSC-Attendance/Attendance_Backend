package com.proj252.AIstopwatch.proj252.u_security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    public fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .loginPage("/login") //!!로그인이 이뤄질 페이지 명시
            .userInfoEndpoint()
            .userService(GoogleOAuth2UserService())
            .and()
            .successHandler(OAuth2LoginSuccessHandler())


        return http.build()
    }
}