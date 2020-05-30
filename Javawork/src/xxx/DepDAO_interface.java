package xxx;

import java.util.List;

public interface  DepDAO_interface    {
	public  void add(DepVO dep);
	public  void update(DepVO dep);
	public  void delete(int DEPINO);
	public  void findbyDEPINO(int DEPINO);
	List<DepVO> getAll();

}
