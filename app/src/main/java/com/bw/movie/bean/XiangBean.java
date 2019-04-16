package com.bw.movie.bean;

import java.util.List;

public class XiangBean {


    /**
     * result : {"director":"吕乐","duration":"102分钟","followMovie":2,"id":21,"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieTypes":"剧情","name":"找到你","placeOrigin":"中国大陆","posterList":["http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn2.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn3.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn4.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn5.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn6.jpg"],"rank":0,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn2.jpg","videoUrl":"http://172.17.8.100/video/movie/zdn/zdn1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn3.jpg","videoUrl":"http://172.17.8.100/video/movie/zdn/zdn2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn4.jpg","videoUrl":"http://172.17.8.100/video/movie/zdn/zdn3.mp4"}],"starring":"姚晨,马伊琍,袁文康,吴昊宸","summary":"律师李捷（姚晨 饰）正在离婚进行时，与前夫争夺女儿抚养权，拼命工作为给孩子最好的生活，幸有保姆孙芳（马伊琍 饰）帮忙照顾孩子视如己出。一日下班，李捷发现保姆孙芳和女儿毫无预兆地消失了，她内心最大的恐惧变成了现实。在追寻孙芳和女儿的下落时，她收到来自家人的谴责声讨，甚至遭到警方的怀疑。几乎崩溃的李捷，靠着惊人的勇气，踏上独自寻访的旅程。在追踪过程中，李捷逐渐接近了另一个女人\u2014\u2014保姆孙芳的人生故事，她的身份原先都是谎言，而真相也将浮出水面\u2026\u2026"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * director : 吕乐
         * duration : 102分钟
         * followMovie : 2
         * id : 21
         * imageUrl : http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg
         * movieTypes : 剧情
         * name : 找到你
         * placeOrigin : 中国大陆
         * posterList : ["http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn2.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn3.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn4.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn5.jpg","http://172.17.8.100/images/movie/stills/zdn/zdn6.jpg"]
         * rank : 0
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn2.jpg","videoUrl":"http://172.17.8.100/video/movie/zdn/zdn1.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn3.jpg","videoUrl":"http://172.17.8.100/video/movie/zdn/zdn2.mp4"},{"imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn4.jpg","videoUrl":"http://172.17.8.100/video/movie/zdn/zdn3.mp4"}]
         * starring : 姚晨,马伊琍,袁文康,吴昊宸
         * summary : 律师李捷（姚晨 饰）正在离婚进行时，与前夫争夺女儿抚养权，拼命工作为给孩子最好的生活，幸有保姆孙芳（马伊琍 饰）帮忙照顾孩子视如己出。一日下班，李捷发现保姆孙芳和女儿毫无预兆地消失了，她内心最大的恐惧变成了现实。在追寻孙芳和女儿的下落时，她收到来自家人的谴责声讨，甚至遭到警方的怀疑。几乎崩溃的李捷，靠着惊人的勇气，踏上独自寻访的旅程。在追踪过程中，李捷逐渐接近了另一个女人——保姆孙芳的人生故事，她的身份原先都是谎言，而真相也将浮出水面……
         */

        private String director;
        private String duration;
        private int followMovie;
        private int id;
        private String imageUrl;
        private String movieTypes;
        private String name;
        private String placeOrigin;
        private int rank;
        private String starring;
        private String summary;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getFollowMovie() {
            return followMovie;
        }

        public void setFollowMovie(int followMovie) {
            this.followMovie = followMovie;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieTypes() {
            return movieTypes;
        }

        public void setMovieTypes(String movieTypes) {
            this.movieTypes = movieTypes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/zdn/zdn2.jpg
             * videoUrl : http://172.17.8.100/video/movie/zdn/zdn1.mp4
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
