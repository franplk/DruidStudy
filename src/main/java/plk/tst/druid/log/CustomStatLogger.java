/**
 * 创建日期 : 2016年12月29日
 * 修改历史 :
 * 1. [2016年12月29日]创建文件 by {康培亮/AB052634}
 */
package plk.tst.druid.log;

import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

/**
 * //TODO 添加类/接口功能描述
 * 
 * @author {康培亮/AB052634}
 */
public class CustomStatLogger implements DruidDataSourceStatLogger {

    private Log logger = LogFactory.getLog(CustomStatLogger.class);

    public CustomStatLogger() {
        logger.debug("");
        configFromProperties(System.getProperties());
    }

    /**
     **/
    @Override
    public void configFromProperties(Properties properties) {
        String property = properties.getProperty("druid.stat.loggerName");
        if (property != null && property.length() > 0) {
            setLoggerName(property);
        }
    }

    /**
     **/
    @Override
    public void log(DruidDataSourceStatValue statvalue) {

    }

    /**
     **/
    @Override
    public void setLogger(Log log) {

    }

    /**
     **/
    @Override
    public void setLoggerName(String name) {

    }
}
