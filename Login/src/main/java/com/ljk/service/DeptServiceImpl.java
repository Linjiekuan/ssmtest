package com.ljk.service;
import static com.ljk.yc.HrmConstants.PAGE_DEFAULT_SIZE;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljk.dao.DeptDAO;
import com.ljk.yc.Dept;
import com.ljk.yc.PageBean;
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	  @Autowired 
	  DeptDAO deptDao;
	    //更新
		public int updateDept(Dept dept){
			return deptDao.updateDept(dept);
		}
		// 添加
		public int addDept(Dept dept){
			return deptDao.addDept(dept);
		}

		// 删除
		public int deleteDept(int id){
			return deptDao.deleteDept(id);
		}

		// 分页
		public List<Dept> getAllDepts( int pageNo, int size, String name){
			return deptDao.getAllDepts((pageNo-1)*size, size, "%"+name+"%");
		}

		// 获取数量
		public int getDeptCount(String name){
			return deptDao.getDeptCount("%"+name+"%");
		}
		public List<Dept> selectUserListByPage() {
			// TODO Auto-generated method stub
			return deptDao.selectUserListByPage();
		}
		public int selectCountByPage() {
			// TODO Auto-generated method stub
			return deptDao.selectCountByPage();
		}
		public PageBean<Dept> findByPage(int currentPage) {
			HashMap<String,Object> map = new HashMap<String,Object>();
	        PageBean<Dept> pageBean = new PageBean<Dept>();
	      //封装当前页数
	        pageBean.setCurrPage(currentPage);
	        //每页显示的数据
	        int pageSize=PAGE_DEFAULT_SIZE;
	        pageBean.setPageSize(pageSize);
	        //封装总记录数
	        int totalCount = deptDao.selectCountByPage();
	        pageBean.setTotalCount(totalCount);
	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean.setTotalPage(num.intValue());

	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        //封装每页显示的数据
	        List<Dept> lists = deptDao.findByPage(map);
	        pageBean.setLists(lists);

	        return pageBean;
		}

}
