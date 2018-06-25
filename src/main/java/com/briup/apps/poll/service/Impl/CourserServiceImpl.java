package com.briup.apps.poll.service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.ICourseService;
@Service
public class CourserServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper courseMapper;
	
	public List<Course>findAll()throws Exception
	{
		CourseExample example=new CourseExample();
		return courseMapper.selectByExample(example);
	}
public 	Course findById(long id)throws Exception{
		return courseMapper.selectByPrimaryKey(id);
	}
	public List<Course>query(String keywords)throws Exception{
		CourseExample example=new CourseExample();
		example.createCriteria().andNameLike(keywords);
		return courseMapper.selectByExample(example);
		//return courseMapper.selsectByExampleWithBLOBs(example);
	}
	public void saveOrUpdate(Course course)throws Exception{
		if(course.getId()!=null)
		{
			courseMapper.updateByPrimaryKey(course);
		}
		else
		{
			courseMapper.insert(course);
		}
		
	}
	public void deleteById(long id)throws Exception{
		courseMapper.deleteByPrimaryKey(id);
	}
	public void batchDelete(List<Long>ids)throws Exception
	{
		for(long id:ids)
		{
			courseMapper.deleteByPrimaryKey(id);
		}
	}
}
