package com.lyz.xingliulian.bean;

import java.util.List;

public class GsonBean {

    /**
     * result : [{"commodityId":182,"commodityName":"美国妮可米勒拉杆箱 炫彩轻盈旅行箱 男女旅游商务硬箱 万向轮登机箱行李箱 20英寸白色 N4635-10-20S","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/lgx/6/1.jpg","price":699,"saleNum":0},{"commodityId":121,"commodityName":"佳能（Canon）EOS 3000D 入门级数码单反相机18-55mm IS II防抖镜头套装 32G内存卡 备用电池 三脚架摄影包等礼包版","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/zxj/1/1.jpg","price":3099,"saleNum":0},{"commodityId":134,"commodityName":"四季沐歌MicoeM-ZN108X智能马桶智能马桶 一体式智能多功能冲洗加温座便器 305/400坑距","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/znsb/7/1.jpg","price":2398,"saleNum":0},{"commodityId":113,"commodityName":"闪充充电器 9V-2A快充 适用 X21/X20/X9s/X9sPlus/X9/XPlay6/Xplay5/X7/X7Plus","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/7/1.jpg","price":85,"saleNum":0},{"commodityId":128,"commodityName":"儿童人工智能机器人玩具语音对话早教第五代学习机3-6-12岁高科技遥控教育语音聊天对话会跳舞的智能机器人","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/znsb/1/1.jpg","price":689,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 182
         * commodityName : 美国妮可米勒拉杆箱 炫彩轻盈旅行箱 男女旅游商务硬箱 万向轮登机箱行李箱 20英寸白色 N4635-10-20S
         * masterPic : http://172.17.8.100/images/small/commodity/xbsd/lgx/6/1.jpg
         * price : 699
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
