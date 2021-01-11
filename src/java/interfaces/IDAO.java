package interfaces;

import java.util.ArrayList;

public interface IDAO <B,I> {
    public int add(B bean);
    public int delete(I Integer);
    public ArrayList<B> findAll(B bean);
    public int update(B bean);
	

}
