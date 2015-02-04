package com.wappi.tenzi;

/**
 * Created by apple on 12/5/14.
 */
public class ListviewObjects
{
    /**
     * The title of the song
     */
    private String text;

    /**
     * Type will reference either a list item or an advertisement
     */
    private int type;

    /**
     * an array holding the tags of each stanza (verse/chorus)
     */
    private String[] stanzatag;

    /**
     * an array holding the stanzas of the song
     */
    private String[] stanza;

    private boolean hasChorus = false;

    /**
     * value holding the position of the song ie song number
     */
    private int objectPosition;

    /**
     * This is the title of the song in english
     */
    private String englishTitle;

    /**
     * This is the refarences of the song in other books
     */
    private String otherReferences;

    /**
     * Object's constructor
     * @param songTitle
     * @param type
     */
    public ListviewObjects (String songTitle, int type, String english, String references) {

        this.text = songTitle;
        this.type = type;
        this.englishTitle = english;
        this.otherReferences = references;
    }

    /**
     * called to return the title of the song
     * @return
     */
    public String getTitle() {
        return text;
    }

    /**
     * method to set the title of the song
     * @param songTitle
     */
    public void setText(String songTitle) {
        this.text = songTitle;
    }

    /**
     * method to return the type of an object whether an advert or a song
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * method to set the type of the object (song/advert)
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * method to set the stanza tag of the song
     * @param receivedStanzaTag
     */
    public void setStanzatag(String[] receivedStanzaTag){
        stanzatag = receivedStanzaTag;
    }

    /**
     * method to set the stanzas of the song
     * @param receivedStanza
     */
    public void setStanza(String[] receivedStanza){
        stanza = receivedStanza;
    }


    /**
     * method to set the position/song_number of the song
     * @param position
     */
    public void setObjectPosition(int position){
        objectPosition = position;
    }

    /**
     * method to return the stanzas of the song
     * @return
     */
    public String[] getStanza(){
        return stanza;
    }

    /**
     * method to return the stanza tags of the song
     * @return
     */
    public String[] getStanzatag(){
        return stanzatag;
    }

    /**
     * method to return the song number/position
     * @return
     */
    public int getObjectPosition(){
        return objectPosition;
    }

    /**
     * A public method to return a english title of the song
     * @return
     */
    public String getEnglishTitle(){
        return englishTitle;
    }

    /**
     * A public method to return the references of a song
     * @return
     */
    public String getOtherReferences(){
        return otherReferences;
    }


    public String doesItHaveAChorus(){
        String temp = "";
        int chorus = 0;
        for(int i = 0; i<stanzatag.length; i++){
            if(stanzatag[i] == "chorus") {
                chorus = 1;
            }
        }

        if(chorus == 1){
            return stanza[1];
        }
        else{
            return stanza[0];
        }

    }


}