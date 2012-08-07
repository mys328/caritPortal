package cn.com.carit.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.carit.common.utils.DataGridModel;
import cn.com.carit.common.utils.JsonPage;
import cn.com.carit.portal.bean.MediaGallery;
import cn.com.carit.portal.dao.MediaGalleryDao;
import cn.com.carit.portal.service.MediaGalleryService;
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class MediaGalleryServiceImpl implements
		MediaGalleryService<MediaGallery> {

	@Resource
	private MediaGalleryDao<MediaGallery> mediaGalleryDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	@Override
	public int saveOrUpdate(MediaGallery t) throws Exception {
		if (t.getId()>0) {
			return mediaGalleryDao.update(t);
		} else {
			return mediaGalleryDao.add(t);
		}
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	@Override
	public int delete(int id) {
		if(id<=0){
			throw new IllegalArgumentException("id must be bigger than 0...");
		}
		return mediaGalleryDao.delete(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public int batchDelete(String ids) {
		if (StringUtils.hasText(ids)) {
			return mediaGalleryDao.batchDelete(ids);
		}
		return 0;
	}
	
	@Override
	public MediaGallery queryById(int id) {
		if(id<=0){
			throw new IllegalArgumentException("id must be bigger than 0...");
		}
		return mediaGalleryDao.queryById(id);
	}

	@Override
	public JsonPage<MediaGallery> queryByExemple(MediaGallery t,
			DataGridModel dgm) {
		if (t==null) {
			throw new NullPointerException("sample is null..");
		}
		if (dgm==null) {
			throw new NullPointerException("DataGridModel is null..");
		}
		return mediaGalleryDao.queryByExemple(t, dgm);
	}

	@Override
	public List<MediaGallery> queryByExemple(MediaGallery t) {
		if (t==null) {
			throw new NullPointerException("sample is null..");
		}
		return mediaGalleryDao.queryByExemple(t);
	}

	@Override
	public List<MediaGallery> queryAll() {
		return mediaGalleryDao.queryAll();
	}

}