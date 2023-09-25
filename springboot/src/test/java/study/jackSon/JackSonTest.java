package study.jackSon;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.easypoi.entity.Student;
import org.apache.commons.lang.StringEscapeUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;

/**
 * @author huangsenwei
 * @Description
 */
public class JackSonTest {
    @Test
    public void toJsonString() throws JsonProcessingException {
        Student student =
                new Student();
        student.setFoodImg("img");
        student.setId(12);
        student.setName("name");

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);

    }

    @Test
    public void toObject() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Student s = objectMapper.readValue("{\"id\":12,\"name\":\"name\",\"foodImg\":\"img\"}",Student.class);
        JsonNode jsonNode = objectMapper.readTree("{\"id\":12,\"name\":\"name\",\"foodImg\":\"img\"}");
        JsonNode id = jsonNode.get("id");
        System.out.println(id.intValue());
        System.out.println(jsonNode.get("name").toPrettyString());
        System.out.println(		jsonNode.get("name").asText());
        System.out.println(s);

    }

    @Test
    public void getPassword() {
//        BasicTextEncryptor encryptor = new BasicTextEncryptor();
//        encryptor.setPassword("pwFSMP2022a");
//        System.out.println(encryptor.decrypt("wCdDizE8PsSSf91ZCnIwqg=="));
//        System.out.println(encryptor.decrypt("vxxqCzzLs/o0sVNwXZjBB6KU5wbapK3W"));
//        xxl Fjf)7sYR%4z^
//        mpoms/Mix#&d04IB
        // 119.nacos vG1lSGU$YBS#oRzB
        // 120.nacos NODXlivRa5#3202
        //mpomsTest  fzq 9K#DZVW7Yn
        // hsw/Fp&yzd3mz9kL
        //qiqi
        //KVR84zm_xn._zcd
        //开发yxpt mp/mp$2022@01!17
        //huangsenwei/Ec$Hsw@921
        //liruifeng/Ec$Lrf#23$%
        //dccp   Dccp20$@#
        BasicTextEncryptor encryptorTwo = new BasicTextEncryptor();
        encryptorTwo.setPassword("lybgeek");
        System.out.println(encryptorTwo.decrypt("mu7fG0dy3EUCWGbR4AhUEkah5bqMQ375"));
        System.out.println(encryptorTwo.encrypt("Minio_tst1"));
//        System.out.println(encryptorTwo.encrypt("Llyy$1949X3"));
//        System.out.println(encryptor.decrypt("Q+tOwlx2WPsMkoMdDcTklw=="));
//        System.out.println(encryptor.decrypt("YdtvbSLet6MzPFMrMJaRaA=="));

        String s = "2";
        System.out.println(Integer.parseInt(s));
        Object p = "2";
        System.out.println(Integer.parseInt(String.valueOf(p)));

//        System.out.println(StringEscapeUtils.escapeHtml("https://wap.gd.10086.cn/nwap/kd/smartHomeZoneNew/index.jsps?selectTab=1&DrainageChannel=QYZXXCX&WT.ac_id=kdxz_190604_O_QYZXXCX&token=YZsidssolg124eb0fbc22c56428babea07accee068&sdc_m_usedTime=426"));
        System.out.println(StringEscapeUtils.escapeHtml("https://wap.gd.10086.cn/nwap/login/SingleLogin.jsps?backurl=https://wap.gd.10086.cn/nwap/kd/smartHomeZoneNew/index.jsps?selectTab=1&DrainageChannel=QYZXXCX&WT.ac_id=kdxz_190604_O_QYZXXCX&token="));
    }

}
