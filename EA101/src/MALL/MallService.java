package MALL;

import java.util.List;

public class MallService {

	private MallDAO_interface dao ;
	
	public MallService() {
		dao = new MallJDBCDAO();
	}
	
	//新增
	public String addMall(Integer commNo, String commName, Integer price, Integer quantity, byte[] img, String intro,
			String age, String player, Integer status) {
		
		MallVO mall = new MallVO();
		mall.setCommNo(commNo);
		mall.setCommName(commName);
		mall.setPrice(price);
		mall.setQuantity(quantity);
		mall.setImg(img);
		mall.setIntro(intro);
		mall.setAge(age);
		mall.setPlayer(player);
		mall.setStatus(status);
		dao.add(mall);
		
		return "新增成功";
	}
	//刪除
	public String deleteMall(Integer commno){
		
		dao.delete(commno);
		
		return "刪除成功";
	}
	//修改
	public String updateMall(Integer commNo, String commName, Integer price, Integer quantity, byte[] img, String intro,
			String age, String player, Integer status){

		MallVO mall = new MallVO();
		mall.setCommNo(commNo);
		mall.setCommName(commName);
		mall.setPrice(price);
		mall.setQuantity(quantity);
		mall.setImg(img);
		mall.setIntro(intro);
		mall.setAge(age);
		mall.setPlayer(player);
		mall.setStatus(status);
		dao.update(mall);
		
		return "修改成功";
		
		
	}
	//用商品名稱查詢，因為我查的可能不只一項回傳list
	public List<MallVO> findByName(String name){
		return dao.findByName(name);
		
	}
	//拿全部
	public List<MallVO> getAll(){
		return dao.getAll();
		
	}
	//取得最新商品前五比
	public List<MallVO> getNew(){
		return dao.getNew();
		
	}
	
	
}
