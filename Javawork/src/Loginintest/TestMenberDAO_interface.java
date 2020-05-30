package Loginintest;

import java.util.List;

public interface TestMenberDAO_interface {
	
	public String add(TestMenberVO TestMenber);
	public void update(TestMenberVO TestMenber);
	public void delete(String userAccount);
	public TestMenberVO findByuserAccount(String userAccount);
	public List<TestMenberVO> getAll();
	
	
}
