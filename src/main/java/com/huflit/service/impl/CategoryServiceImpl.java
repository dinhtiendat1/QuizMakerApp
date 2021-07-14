package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.service.CategoryService;
import com.huflit.dto.CategoryDto;
import com.huflit.entity.Category;
import com.huflit.repository.CategoryRepository;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;

	CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> findAll() {
		List<Category> entities = categoryRepository.findByStatusTrue();
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();

		for (Category entity : entities) {
			dtos.add(new CategoryDto(entity.getId(), entity.getName(), entity.getIcon()));
		}

		return dtos;
	}
	
	@Override
	public List<CategoryDto> findAllStatusFalse() {
		List<Category> entities = categoryRepository.findByStatusFalse();
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();

		for (Category entity : entities) {
			dtos.add(new CategoryDto(entity.getId(), entity.getName(), entity.getIcon()));
		}

		return dtos;
	}

	@Override
	public CategoryDto findById(int id) {
		Category entity = categoryRepository.getById(id);
		return new CategoryDto(entity.getId(), entity.getName(), entity.getIcon());
	}
	
	@Override
	public CategoryDto findByIdAndStatusTrue(int id) {
		Category entity = categoryRepository.findByIdAndStatusTrue(id);
//		if(entity)
		return new CategoryDto(entity.getId(), entity.getName(), entity.getIcon());
	}

	@Override
	public void update(int id, CategoryDto dto) {
		if (categoryRepository.existsById(id)) {
			Category entity = categoryRepository.getById(dto.getId());
			if (entity == null)
				return;
			entity.setIcon(dto.getIcon());
			entity.setName(dto.getName());
			categoryRepository.save(entity);
		}

	}

	@Override
	public void add(CategoryDto dto) {
		Category entity = new Category(dto.getName(), dto.getIcon(), true);
		categoryRepository.save(entity);
	}
	
	@Override
	public void addByUser(CategoryDto dto) {
		Category entity = new Category(dto.getName(), dto.getIcon(), false);
		categoryRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void approve(int id) {
		Category entity = categoryRepository.getById(id);
		entity.setStatus(true);
		categoryRepository.save(entity);
		
	}
}
