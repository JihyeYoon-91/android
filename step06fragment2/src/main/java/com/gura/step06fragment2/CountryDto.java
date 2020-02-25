package com.gura.step06fragment2;

import java.io.Serializable;

public class CountryDto implements Serializable {

        private int resId;
        private String name;
        private String content;

        public CountryDto(){}

        public CountryDto(int resId, String name, String content) {
            this.resId = resId;
            this.name = name;
            this.content = content;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;

    }
}
