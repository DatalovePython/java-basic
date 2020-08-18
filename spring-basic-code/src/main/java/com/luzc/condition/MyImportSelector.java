package com.luzc.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author luzc
 * @date 2020/8/18 15:28
 * @desc
 */

//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值，就是要导入容器的组件全类名
    //AnnotationMetadata 当前标注import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.luzc.bean.Blue","com.luzc.bean.Red"};
    }
}
