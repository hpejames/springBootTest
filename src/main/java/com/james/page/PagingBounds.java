package com.james.page;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class PagingBounds<T> extends RowBounds {

    /* 总记录数 */
    private int total;

    /* 查询的起始位置 */
    private int offset;

    /* 查询多少行记录 */
    private int limit;

    /** １页表示数据的件数 */
    private int pageSize = 15;

    /** 当前所在页 */
    private int pageNo = 1;

    /** 所有页数 */
    private int totalPage = 1;

    /** 检索出来数据 */
    private List<T> results;

    public PagingBounds() {
        this.offset = NO_ROW_OFFSET;
        this.limit = pageSize;
    }

    public PagingBounds(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
        // １ページあたりの件数が「0」の場合、
        if (this.pageSize <= 0) {
            return 0;

        } else {

            // ページ情報より、最初の位置を計算する
            int offset = (this.pageNo - 1) * this.pageSize;

            if (offset < 0) {
                offset = 0;
            }

            return offset;
        }
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
        return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

    public void setMeToDefault() {
        this.offset = NO_ROW_OFFSET;
        this.limit = pageSize;
    }
}