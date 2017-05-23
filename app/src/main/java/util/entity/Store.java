package util.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */

public class Store {
    private  List<String> mNames;//店铺名字
    private  List<String> mPaths;//店铺log
    private  List<String> mTimes;//营业时间
    private  List<String> mStoreId;//店铺id
    private  List<String> mDistance;//距离

    public Store(List<String> mNames, List<String> mPaths, List<String> mTimes, List<String> mStoreId,
                 List<String> mDistance, List<String> mStart) {
        this.mNames = mNames;
        this.mPaths = mPaths;
        this.mTimes = mTimes;
        this.mStoreId = mStoreId;
        this.mDistance = mDistance;
        this.mStart = mStart;
    }

    private List<String> mStart;//星级

    public List<String> getmNames() {
        return mNames;
    }

    public void setmNames(List<String> mNames) {
        this.mNames = mNames;
    }

    public List<String> getmPaths() {
        return mPaths;
    }

    public void setmPaths(List<String> mPaths) {
        this.mPaths = mPaths;
    }

    public List<String> getmTimes() {
        return mTimes;
    }

    public void setmTimes(List<String> mTimes) {
        this.mTimes = mTimes;
    }

    public List<String> getmStoreId() {
        return mStoreId;
    }

    public void setmStoreId(List<String> mStoreId) {
        this.mStoreId = mStoreId;
    }

    public List<String> getmDistance() {
        return mDistance;
    }

    public void setmDistance(List<String> mDistance) {
        this.mDistance = mDistance;
    }

    public List<String> getmStart() {
        return mStart;
    }

    public void setmStart(List<String> mStart) {
        this.mStart = mStart;
    }


}
