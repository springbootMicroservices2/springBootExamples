package com.sample.poc.demo.condition;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.sample.poc.demo.config.EmployeeBeanConfig;

public class BeanPresennceCondition implements Condition {

	/**
	 * @Conditional checking based on whether a Bean object is present or not in
	 *              Spring Application Context. If bean is available,
	 *              BeanPresennceCondition’s matches() method return true.
	 *              Otherwise, it throws NoSuchBeanDefinitionException exception.
	 */

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		EmployeeBeanConfig employeeBeanConfig = null;
		try {
			employeeBeanConfig = (EmployeeBeanConfig) context.getBeanFactory().getBean("employeeBeanConfig");
		} catch (NoSuchBeanDefinitionException ex) {

		}
		return employeeBeanConfig != null;
	}

	/**
	 * Now change BeanPresennceCondition class matches() method logic as show below
	 * to check the failure case of the Condition. Here we are checking for
	 * “employeeBeanConfig2” bean instead of “employeeBeanConfig”. It will
	 * definitely fail because our application does not have this bean
	 * configuration.
	 * 
	 * org.springframework. beans.factory.NoSuchBeanDefinitionException: No bean
	 * named 'employee' is defined.
	 */

	/*
	 * @Override public boolean matches(ConditionContext context,
	 * AnnotatedTypeMetadata metadata) { EmployeeBeanConfig employeeBeanConfig =
	 * null; try { employeeBeanConfig =
	 * (EmployeeBeanConfig)context.getBeanFactory().getBean("employeeBeanConfig2");
	 * }catch(NoSuchBeanDefinitionException ex) {
	 * 
	 * } return employeeBeanConfig != null; }
	 */
}