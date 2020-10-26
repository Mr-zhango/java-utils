package cn.myfreecloud.office;

import cn.myfreecloud.office.inportexcel.CsvUtil;
import cn.myfreecloud.office.inportexcel.DataAndTypeCsv;
import cn.myfreecloud.office.inportexcel.POIFetchUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootTest
class OfficeDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void test1() throws IOException {

        String pathname = "D:\\Desktop\\radar\\sourceone.csv";
        File file = new File(pathname);
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);

        List<DataAndTypeCsv> csvData = CsvUtil.getCsvData(multipartFile, DataAndTypeCsv.class);

        for (DataAndTypeCsv csvDatum : csvData) {

            System.out.println(csvDatum);
        }
    }
}
