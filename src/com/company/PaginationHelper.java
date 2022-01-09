package com.company;

import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {
    private int itemsPerPage;
    private int itemCount;


    /**
     * The constructor takes in an array of items and an integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemCount = collection.size();
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() { return this.itemCount; }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (int)Math.ceil((double)this.itemCount / this.itemsPerPage);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if ( (pageIndex > -1) && (pageIndex < this.pageCount())) {
            if (this.pageCount() == 1)
                return this.itemCount();
            if ( (this.itemCount() % itemsPerPage != 0) && (pageIndex == this.pageCount() - 1) )
                return this.itemCount() - (pageIndex * itemsPerPage);
            else
                return itemsPerPage;
        }
        else
            return -1;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if ( (itemIndex > -1) && (itemIndex <= this.itemCount) && (this.pageCount() != 0))
            return (int)Math.floor((double)itemIndex / this.itemsPerPage);
        else
            return -1;
    }
}