package manager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData{

    @DataProvider
    public Iterator<Object[]> loginModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{});
        list.add(new Object[]{});
        list.add(new Object[]{});
        return list.iterator();
    }

}