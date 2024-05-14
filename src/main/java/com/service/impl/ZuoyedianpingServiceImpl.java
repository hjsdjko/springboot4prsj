package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuoyedianpingDao;
import com.entity.ZuoyedianpingEntity;
import com.service.ZuoyedianpingService;
import com.entity.vo.ZuoyedianpingVO;
import com.entity.view.ZuoyedianpingView;

@Service("zuoyedianpingService")
public class ZuoyedianpingServiceImpl extends ServiceImpl<ZuoyedianpingDao, ZuoyedianpingEntity> implements ZuoyedianpingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuoyedianpingEntity> page = this.selectPage(
                new Query<ZuoyedianpingEntity>(params).getPage(),
                new EntityWrapper<ZuoyedianpingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuoyedianpingEntity> wrapper) {
		  Page<ZuoyedianpingView> page =new Query<ZuoyedianpingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuoyedianpingVO> selectListVO(Wrapper<ZuoyedianpingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuoyedianpingVO selectVO(Wrapper<ZuoyedianpingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuoyedianpingView> selectListView(Wrapper<ZuoyedianpingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuoyedianpingView selectView(Wrapper<ZuoyedianpingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
