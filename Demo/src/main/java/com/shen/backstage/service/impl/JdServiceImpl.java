package com.shen.backstage.service.impl;

import com.shen.backstage.config.parse.JdParse;
import com.shen.backstage.config.util.HttpRequest;
import com.shen.backstage.dao.JdMapper;
import com.shen.backstage.entity.JdModel;
import com.shen.backstage.service.JdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service("JdService")
public class JdServiceImpl implements JdService {

    @Autowired(required = false)
    private JdMapper jdMapper;

    @Override
    public int insert(String word, int first, int end, int number) {
        //设置关键词
        String keyword = word;
        //价格区间
        int firstprice = first;
        int endprice = end;
        //输入爬取的总页数
        int sumpagenumber = number;
        for (int i = 1; i <= sumpagenumber; i++) {
            String html = null;
            try {
                html = HttpRequest.getRawHtml(keyword, i, firstprice, endprice);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<JdModel> dataslist = JdParse.getData(html, keyword);
            //循环输出抓取的数据
            for (JdModel jd : dataslist) {
                System.out.println("itemId:" + jd.getItemId() + "\t" + "itemName:" + jd.getItemName() + "\t" + "itemPrice:" + jd.getItemPrice() + "\tcommentnumber:" + jd.getCommentNumber() +"\timgurl:"+jd.getItemImgUrl()+ "\titemurl:" + jd.getItemUrl() + "\tshopname:" + jd.getShopName() + "\tshopurl:" + jd.getShopUrl() + "\tcrawl_time:" + jd.getCrawlerTime()+"\ttype:"+jd.getType());
            }
            jdMapper.insert(dataslist);
        }
        return 0;
    }
}
