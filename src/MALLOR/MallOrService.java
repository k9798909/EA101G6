package MALLOR;

import java.util.List;


public class MallOrService {
	
private MallOrDAO_interface dao ;
	
	public MallOrService() {
		dao = new MallOrJDBCDAO();
	}
	
	//新增
	public String addMallOr(Integer mbrNo, java.sql.Date orDate, String take, String address, Integer status,
			Integer payStatus, Integer boxStatus) {
		MallOrVO vo = new MallOrVO();
		vo.setMbrNo(mbrNo);
		vo.setOrDate(orDate);
		vo.setTake(take);
		vo.setAddress(address);
		vo.setStatus(status);
		vo.setPayStatus(payStatus);
		vo.setBoxStatus(boxStatus);
		dao.add(vo);
		return "新增成功";
	}
	//刪除
	public String deleteMallOr(Integer mallOrNo){
		dao.delete(mallOrNo);
		return "刪除成功";
	}
	//修改
	public String updateMallOr(Integer mallOrNo, Integer mbrNo, java.sql.Date orDate, String take, String address, Integer status,
			Integer payStatus, Integer boxStatus){
		MallOrVO vo = new MallOrVO();
		vo.setMallOrNo(mallOrNo);
		vo.setMbrNo(mbrNo);
		vo.setOrDate(orDate);
		vo.setTake(take);
		vo.setAddress(address);
		vo.setStatus(status);
		vo.setPayStatus(payStatus);
		vo.setBoxStatus(boxStatus);
		dao.update(vo);
		
		return "修改成功";
		
		
	}
	
	public List<MallOrVO> getAll(){
		return dao.getAll();
	}
	public List<MallOrVO> findByMbrNo(Integer mbrNo){
		return dao.findByMbrNo(mbrNo);
	}
	public List<MallOrVO> findByStatus(Integer status){
		return dao.findByStatus(status);
	}
	public MallOrVO findByOrNo(Integer mallOrNo) {
		return dao.findByOrNo(mallOrNo);
	}

	
}
