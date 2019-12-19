package com.artiecode.itrip.service.impl;

import com.artiecode.itrip.pojo.vo.ItripHotelVO;
import com.artiecode.itrip.pojo.vo.SearchHotCityVO;
import com.artiecode.itrip.service.SearchService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>搜索模块业务层接口实现类</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
@Service("searchService")
@Transactional
public class SearchServieImpl implements SearchService {
	@Autowired
	private SolrClient solrClient;

	/**
	 * <b>根据查询视图获得热门城市酒店列表</b>
	 * @param searchHotCityVO
	 * @return
	 * @throws Exception
	 */
	public List<ItripHotelVO> searchItripHotelListByHotCity(SearchHotCityVO searchHotCityVO) throws Exception {
		// 构建Solr数据查询对象
		SolrQuery solrQuery = new SolrQuery("*:*");
		// 对于Solr来说查询可以按照分页的情况进行查询，因此，在该需求下，默认查询的开始也为0，连续查询的条数就是需要展示的条数
		// 设定开始的页码，展示第一页
		solrQuery.setStart(0);
		// 设定连续查询条数
		solrQuery.setRows(searchHotCityVO.getCount());
		// 进行查询，获得结果
		QueryResponse queryResponse = solrClient.query(solrQuery);
		// 通过QueryResponse获得结果
		List<ItripHotelVO> itripHotelVOList = queryResponse.getBeans(ItripHotelVO.class);
		return itripHotelVOList;
	}
}
