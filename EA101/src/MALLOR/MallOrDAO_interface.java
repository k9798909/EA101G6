package MALLOR;

import java.util.List;

public interface MallOrDAO_interface {

	public void add(MallOrVO mallor);	
	public void update(MallOrVO mallor);
	public void delete(Integer mallOrNo);
	public List<MallOrVO> getAll();
	public List<MallOrVO> findByMbrNo(Integer mbrNo);
	public List<MallOrVO> findByStatus(Integer status);
	public MallOrVO findByOrNo(Integer mallOrNo);
	
	
	
	
	
}
