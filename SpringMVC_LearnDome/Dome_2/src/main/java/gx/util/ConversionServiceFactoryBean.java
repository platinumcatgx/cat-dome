package gx.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConversionServiceFactoryBean implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (null == s) throw new RuntimeException("source is null!");
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("Converter String to Date failed!");
        }
    }
}
