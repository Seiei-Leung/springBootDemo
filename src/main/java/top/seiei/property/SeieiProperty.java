package top.seiei.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 导入配置文件，化成具体实例
 */
@Component
@ConfigurationProperties(prefix = "seiei")
public class SeieiProperty {
    private String txt;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
