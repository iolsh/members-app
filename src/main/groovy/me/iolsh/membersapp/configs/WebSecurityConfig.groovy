package me.iolsh.membersapp.configs

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers('/**')

	}
}
