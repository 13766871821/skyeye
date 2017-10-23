package com.hfax.openplatform.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

public class MapperUtil {

	private static final Log log = LogFactory.getLog(MapperUtil.class);

	/**
	 * copy对象，基本类型数据不同不可以copy
	 * @param source
	 * @param target
	 * @throws Exception
	 */
	public static void defaultBasicCopy(Object source, Object target) throws Exception {
		if (source == null || target == null) {
			log.error("source == null || target == null");
			return;
		}
		BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
		copier.copy(source, target, null);
	}

	/**
	 * copy对象，基本类型数据不同可以copy
	 * @param source
	 * @param target
	 * @throws Exception
	 */
	public static void deepBasicCopy(Object source, Object target) throws Exception {
		if (source == null || target == null) {
			log.error("source == null || target == null");
			return;
		}
		BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), true);
		copier.copy(source, target, null);
	}

	/**
	 * 扩展copy，自定义实现Converter接口
	 * @param source
	 * @param target
	 * @param converter
	 * @throws Exception
	 */
	public static void deepExtendedCopy(Object source, Object target, Converter converter) throws Exception {
		if (source == null || target == null || converter == null) {
			log.error("source == null || target == null || converter == null");
			return;
		}
		BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), true);
		copier.copy(source, target, converter);
	}
}
