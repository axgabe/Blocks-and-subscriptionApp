package com.alphaboom.guideforupwork.data;

public class ContentModel {

    private int categoryTitle, img, textTitleOne, textDescriptionOne, textTitleTwo,
            textDescriptionTwo, textTitleThree, textDescriptionThree, textTitleFour, textDescriptionFour;

    public ContentModel(int categoryTitle, int img) {

        this.categoryTitle = categoryTitle;
        this.img = img;
    }

    public ContentModel(int categoryTitle, int img, int textTitleOne, int textDescriptionOne, int textTitleTwo,
                        int textDescriptionTwo, int textTitleThree, int textDescriptionThree, int textTitleFour, int textDescriptionFour) {

        this.categoryTitle = categoryTitle;
        this.img = img;
        this.textTitleOne = textTitleOne;
        this.textDescriptionOne = textDescriptionOne;
        this.textTitleTwo = textTitleTwo;
        this.textDescriptionTwo = textDescriptionTwo;
        this.textTitleThree = textTitleThree;
        this.textDescriptionThree = textDescriptionThree;
        this.textTitleFour = textTitleFour;
        this.textDescriptionFour = textDescriptionFour;
    }

    public ContentModel(int textTitleOne, int textDescriptionOne, int textTitleTwo, int textDescriptionTwo,
                        int textTitleThree, int textDescriptionThree, int textTitleFour, int textDescriptionFour) {
        this.textTitleOne = textTitleOne;
        this.textDescriptionOne = textDescriptionOne;
        this.textTitleTwo = textTitleTwo;
        this.textDescriptionTwo = textDescriptionTwo;
        this.textTitleThree = textTitleThree;
        this.textDescriptionThree = textDescriptionThree;
        this.textTitleFour = textTitleFour;
        this.textDescriptionFour = textDescriptionFour;
    }

    public int getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(int categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getTextTitleOne() {
        return textTitleOne;
    }

    public void setTextTitleOne(int textTitleOne) {
        this.textTitleOne = textTitleOne;
    }

    public int getTextDescriptionOne() {
        return textDescriptionOne;
    }

    public void setTextDescriptionOne(int textDescriptionOne) {
        this.textDescriptionOne = textDescriptionOne;
    }

    public int getTextTitleTwo() {
        return textTitleTwo;
    }

    public void setTextTitleTwo(int textTitleTwo) {
        this.textTitleTwo = textTitleTwo;
    }

    public int getTextDescriptionTwo() {
        return textDescriptionTwo;
    }

    public void setTextDescriptionTwo(int textDescriptionTwo) {
        this.textDescriptionTwo = textDescriptionTwo;
    }

    public int getTextTitleThree() {
        return textTitleThree;
    }

    public void setTextTitleThree(int textTitleThree) {
        this.textTitleThree = textTitleThree;
    }

    public int getTextDescriptionThree() {
        return textDescriptionThree;
    }

    public void setTextDescriptionThree(int textDescriptionThree) {
        this.textDescriptionThree = textDescriptionThree;
    }

    public int getTextTitleFour() {
        return textTitleFour;
    }

    public void setTextTitleFour(int textTitleFour) {
        this.textTitleFour = textTitleFour;
    }

    public int getTextDescriptionFour() {
        return textDescriptionFour;
    }

    public void setTextDescriptionFour(int textDescriptionFour) {
        this.textDescriptionFour = textDescriptionFour;
    }
}
