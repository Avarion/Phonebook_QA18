package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData{

    @DataProvider
    public Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{User.builder().email("avarion87@gmail.com").password("Illumiel1!").build()});
        list.add(new Object[]{User.builder().email("avarion87@gmail.com").password("Illumiel1!").build()});
        list.add(new Object[]{User.builder().email("avarion87@gmail.com").password("Illumiel1!").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.cvs")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{User.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}