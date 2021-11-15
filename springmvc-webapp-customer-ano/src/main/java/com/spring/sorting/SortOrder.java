package com.spring.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortOrder {
	private List<SortParam> sortParams = new ArrayList<>();
	
	public SortOrder addSortParam(SortParam sortParam) {
        if (!sortParams.contains(sortParam)) {
            sortParams.add(sortParam);
        }
        return this;
    }
	
	public SortOrder addParam(String property, boolean asc) {
        return this.addSortParam(new SortParam(property, asc));
    }
	
	public List<SortParam> getSortParams() {
		return sortParams;
	}

	public String getSqlOrder() {
		StringBuilder sb = new StringBuilder();
		
		Iterator<SortParam> iterator = sortParams.iterator();
		
		while (iterator.hasNext()) {
            SortParam sortParam = iterator.next();
            String sortPoperty = sortParam.getProperty();
			
            if (sortPoperty != null) {
            	sb.append(sortParam.getProperty());
    			
    			// default ASC
    			if (!sortParam.isAccending()) {
    				sb.append(" DESC ");
    			}
    			
    			if (iterator.hasNext()) {
                    sb.append(", ");
                }
            }
		}
		
		 if (sb.length() > 0) {
			 sb.insert(0, " ORDER BY ");
		 }
		
		return sb.toString();
	};
}
