package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

public interface PromotionAdService {

    /*
       分页查询广告信息
    */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /*
        广告新增
     */
    void savePromotionAd(PromotionAd promotionAd);

    /*
        广告修改
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /*
        回显广告信息
     */
    PromotionAd findPromotionAdById(int id);

    /*
         广告动态上下线
     */
    public void  updatePromotionAdStatus(int id, int status);


}
