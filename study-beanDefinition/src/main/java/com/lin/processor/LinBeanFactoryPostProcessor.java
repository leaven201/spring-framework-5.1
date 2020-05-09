package com.lin.processor;

import com.lin.services.ReplaceService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author LinZebin
 * @date 2020/5/3 11:27 上午
 */
//@Component
public class LinBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		GenericBeanDefinition beanService = (GenericBeanDefinition) beanFactory.getBeanDefinition("beanService");
		beanService.setBeanClass(ReplaceService.class);
	}
}
