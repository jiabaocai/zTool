/**
 * https://github.com/auzll/zTool
 */
package z.tool.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import z.tool.util.ToStringBuilder;
import z.tool.web.Page;

import com.google.common.collect.Maps;

/**
 * 分页查询的数据结果
 * @author auzll@163.com
 */
public class QueryResult<T> {
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static final QueryResult<?> EMPTY_RESULT = new QueryResult(0, Collections.emptyList()) {
        @Override public QueryResult add(String key, Object value) { return this; }
        @Override public void setOthers(Map others) { }
        @Override public Page toPage() { return Page.emptyPage(); }
        @Override public Page toPage(Page page) { return Page.emptyPage(); }
    };
    
    @SuppressWarnings("unchecked")
    public static <T>QueryResult<T> emptyResult() {
        return (QueryResult<T>) EMPTY_RESULT;
    }
    
    private int count;
    private List<T> results;
    
    private Map<String, Object> others;
    
    public QueryResult() {
    }
    
    public QueryResult(int count, List<T> results) {
        this.count = count;
        this.results = results;
    }
    
    public QueryResult<T> add(String key, Object value) {
        if (null == this.others) {
            this.others = Maps.newHashMap();
        }
        this.others.put(key, value);
        return this;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Object> getOthers() {
        return others;
    }
    
    public List<T> getResults() {
        return results;
    }

    public void setOthers(Map<String, Object> others) {
        this.others = others;
    }
    
    public Page toPage() {
        return toPage(null);
    }

    public Page toPage(Page page) {
        if (null == page) {
            page = new Page();
        }
        page.setCount(getCount());
        page.setOthers(getOthers());
        page.setRecordList(getResults());
        return page;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder()
            .add("count", count)
            .add("results", results)
            .add("others", others)
            .build();
    }
}
