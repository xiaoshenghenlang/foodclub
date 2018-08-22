package com.ljh.foodclub.bean;

import java.util.List;

/**
 * Description:
 * Date on 2018/6/22
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class TestBean {

    /**
     * pageToken : 3
     * retcode : 000000
     * dataType : news
     * data : [{"likeCount":null,"commentCount":null,"content":"今日,超颜值二次元动作网游《封印者》有新消息释出。异之章新剧情、苍鹰守卫城与城之庭院等新地图即将解禁!此前开启预约的新角色白·温彻斯特也正式曝光,恭喜苍鹰队又添一名新的成员。与此同时,第三季剧情视频也揭开了其神秘的面纱,羊狼鹰战争全面爆发,被迫卷入命运漩涡的...","tags":null,"id":"b2b069f18cc5c356973f77beb2864c26","publishDate":1531367160,"posterId":"games.qq.com","title":"新剧情异之章即将开启 《封印者》新角色白即将上线","posterScreenName":"腾讯","imageUrls":null,"shareCount":null,"url":"http://games.qq.com/a/20180712/023849.htm","publishDateStr":"2018-07-12T03:46:00"},{"likeCount":null,"commentCount":null,"content":"而英格兰队的首选蓝色短裤也与助理裁判和VAR裁判的裁判服冲突,为此,索斯盖特的球队将会在半决赛身穿全白的球衣出战。值得一提的是,英格兰参加1966世界杯和1990世界杯半决赛时,也都是身穿白色球衣,在1966年,三狮军团更是一路杀到最后决赛并且历史上第一次也是唯一一次夺...","tags":null,"id":"812342cce2869f749d9b9980d289eca2","publishDate":1531086720,"posterId":"2018.qq.com","title":"命中注定 英格兰第三次出战世界杯半决赛还穿白色球衣","posterScreenName":"腾讯","imageUrls":["http://p9.qhimg.com/t012f52a12ffbb7df94.jpg?size=641x436"],"shareCount":null,"url":"http://2018.qq.com/a/20180709/002356.htm","publishDateStr":"2018-07-08T21:52:00"},{"likeCount":null,"commentCount":null,"content":" 在新赛季新版本中,野区遭到了巨大的改动。打野装备无论是在属性,还是价格上,都有所上调。新赛季注定是打野崛起的一个赛季,那么当前版本排名前五的打野英雄都有谁呢? ","tags":null,"id":"ac9247b2634d194c4a6e3aeab09a3582","publishDate":1530787380,"posterId":"games.qq.com","title":"王者荣耀:S12打野英雄TOP5 你们要的白龙吟回","posterScreenName":"腾讯","imageUrls":null,"shareCount":null,"url":"http://games.qq.com/a/20180705/035617.htm","publishDateStr":"2018-07-05T10:43:00"}]
     * appCode : qihoo
     * hasNext : true
     */

    private String pageToken;
    private String retcode;
    private String dataType;
    private String appCode;
    private boolean hasNext;
    private List<DataBean> data;

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * likeCount : null
         * commentCount : null
         * content : 今日,超颜值二次元动作网游《封印者》有新消息释出。异之章新剧情、苍鹰守卫城与城之庭院等新地图即将解禁!此前开启预约的新角色白·温彻斯特也正式曝光,恭喜苍鹰队又添一名新的成员。与此同时,第三季剧情视频也揭开了其神秘的面纱,羊狼鹰战争全面爆发,被迫卷入命运漩涡的...
         * tags : null
         * id : b2b069f18cc5c356973f77beb2864c26
         * publishDate : 1531367160
         * posterId : games.qq.com
         * title : 新剧情异之章即将开启 《封印者》新角色白即将上线
         * posterScreenName : 腾讯
         * imageUrls : null
         * shareCount : null
         * url : http://games.qq.com/a/20180712/023849.htm
         * publishDateStr : 2018-07-12T03:46:00
         */

        private Object likeCount;
        private Object commentCount;
        private String content;
        private Object tags;
        private String id;
        private int publishDate;
        private String posterId;
        private String title;
        private String posterScreenName;


        private String[] imageUrls;
        private Object shareCount;
        private String url;
        private String publishDateStr;

        public String[] getImageUrls() {
            return imageUrls;
        }

        public void setImageUrls(String[] imageUrls) {
            this.imageUrls = imageUrls;
        }
        public Object getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(Object likeCount) {
            this.likeCount = likeCount;
        }

        public Object getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(Object commentCount) {
            this.commentCount = commentCount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(int publishDate) {
            this.publishDate = publishDate;
        }

        public String getPosterId() {
            return posterId;
        }

        public void setPosterId(String posterId) {
            this.posterId = posterId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPosterScreenName() {
            return posterScreenName;
        }

        public void setPosterScreenName(String posterScreenName) {
            this.posterScreenName = posterScreenName;
        }

        public Object getShareCount() {
            return shareCount;
        }

        public void setShareCount(Object shareCount) {
            this.shareCount = shareCount;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPublishDateStr() {
            return publishDateStr;
        }

        public void setPublishDateStr(String publishDateStr) {
            this.publishDateStr = publishDateStr;
        }
    }
}
