package com.wappi.tenzi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.wappi.tenzi.R;

import java.util.ArrayList;
import java.util.List;

import adapter.gridViewAdapter;

/**
 *  Created by isaiah on 5/14/14.
 */
public class MainActivity extends Activity{

    /**
     * Start Of The Songs
     */


    public String[] stanza_tags1 = {"verse" ,"chorus", "verse", "verse","verse","verse","verse","verse"};
    public String[] stanza1 = {
            "Mwokozi Umeokoa \nNimekua wako wewe,\nDamu imenisafisha \nSifa kwa mwana kondoo\n",
            "Utukufu Aleluya \nSifa kwa mwana \nkondoo\nDamu imenisafisha\nUtukufu kwa Yesu\n",
            "Nilijitahidi sana\nIla sikupata raha\nBali kwa kumtegemea\nNilipata Baraka\n",
            "Daima namtegemea\nDamu ikifanya kazi,\nNikioga kwa chemchemi\nItokayo Mwokozi\n",
            "Sasa nimewekwa wakfu,\nNitaishi kwako wewe\nFahari nashuhudia\nYa wokovu wa bure",
            "Nasimama kwake Yesu,\nAmeponya roho yangu\nAmeniondoa dhambi\nAnifanye mzima",
            "Nilikua Kifungoni\nNiliteswa na dhambi\nNilifungwa minyororo\nYesu akanifungua",
            "Sifa, ameninunua!\nSifa, nguvu za wokovu!\nSifa, Bwana huhifadhi\nSifa zake milele."
    };

    public String[] stanza_tags2 = {"verse" ,"chorus", "verse", "verse", "verse", "verse"};


    public String[] stanza2 = {
            "Twamsifu Mungu kwa Mwana wa pendo \nAlietufia na kupaa juu\n",
            "Aleluya! Usifiwe; Aleluya! Amin \nAleluya! Usifiwe, utubariki\n",
            "Twamsifu Mungu kwa Roho Mtakatifu\nAmetufunulia Mwokozi wetu\n",
            "Twamsifu Mwana, Aliyetufia\nAliyetwaa dhambi akazifuta\n",
            "Twamsifu Mungu wa neema yote,\nAmetukomboa akatuongoza\n",
            "Tuamshe tena, tujaze na pendo\nNa moyoni uwashe moto wa Roho\n"
    };

    public String[] stanza_tags15 = {"verse" ,"chorus", "verse", "verse", "verse"};


    public String[] stanza15 = {
            "Chakutumaini sina \n ila damu yake Bwana,\n Sina wema wa kutosha \n Dhambi zangu kuziosha\n",
            "Kwake Yesu nasimama \nNdiye Mwamba: ni\nsalama\nNdiye Mwamba: ni\nsalama\n",
            "Njia yangu iwe ndefu\nYeye hunipa wokovu\nMawimbi yakinipiga\nNguvi zake ndio nanga.\n",
            "Damu yake na sadaka\nNategemea daima,\nYote chini yakiisha\nMwokozi atanitosha.\n",
            "Nikiitwa hukumuni,\nRohoni nina amani\nNikivikwa haki yake\nSina hofu mbele zake"
    };

    public String[] stanza_tags3 = {"verse", "verse", "Verse", "verse", "verse", "verse"};
    public String[] stanza_tags4 = {"verse","verse","verse","verse","verse","verse"};
    public String[] stanza_tags5 = {"verse","verse","verse","verse","verse","verse"};
    public String[] stanza_tags6 = {"verse","verse","verse","verse"};
    public String[] stanza_tags7 = {"verse","chorus","verse","verse","verse","verse","verse"};
    public String[] stanza_tags8 = {"verse", "verse", "verse"};
    public String[] stanza_tags9 = {"verse","verse","verse"};
    public String[] stanza_tags10 = {"verse","chorus","verse","verse","verse"};
    public String[] stanza_tags11 = {"verse","chorus","verse","verse","verse","verse"};
    public String[] stanza_tags12 = {"verse","verse","verse","verse","verse"};
    public String[] stanza_tags13 = {"verse","verse","verse","verse"};
    public String[] stanza_tags14 = {"verse","verse","verse","verse"};
    public String[] stanza_tags16 = {"verse","verse","verse","verse"};
    public String[] stanza_tags17 = {"verse","verse","verse","verse"};
    public String[] stanza_tags18 = {"verse","verse","verse","verse"};
    public String[] stanza_tags19 = {"verse","verse","verse","verse"};
    public String[] stanza_tags20 = {"verse","verse","verse","verse"};

    public String[] stanza3 = {
            "Hata ndimi elfu elfu,\nHazitoshi kweli\nBwana Yesu kumsifu,\nKwa zake fadhili",
            "Yesu, jina liwezalo\nKufukuza hofu,\nLanifurahisha hilo,\nLanipa wokovu.",
            "Jina hilo ni uzima;\nNi afya; amani;\nLaleta habari njema;\nTwalipiwa deni.",
            "Yesu huvunja mapingu\nya dhambi moyoni;\nMsamaha, tena nguvu,\nTwapata rohoni.",
            "Kwa sauti yake vile\nWafu hufufuka\nWakafurahi milele,\nPasipo mashaka.",
            "Ewe Yesu wangu Bwana\nUwezo nipewe,\nKuhubiri kote sana,\nWote wakujue"
    };

    public String[] stanza4 = {
            "Jina la Yesu salamu! \nlisujudieni\nninyi mbinguni, hukumu \nNa enzi mpeni \n",
            "Enzi na apewe kwetu, \nWatetea dini; \nMtukuzeni Bwana wenu, \nNa enzi mpeni\n",
            "Enyi mbegu ya rehema, \nNanyi msifuni;\nMmeponywa kwa \nneema, \nNa enzi mpeni.\n",
            "Wenye dhambi \nkumbukeni \nya msalabani,\nKwa furaha msifuni, \nNa enzi mpeni.\n",
            "Kila mtu duniani \nMsujudieni,\nKote-kote msifuni, \nNa enzi mpeni.\n",
            "Sisi na wao pamoja \nTu mumo sifani, \nMilele sifa ni moja, \nNi \"Enzi mpeni.\"\n"
    };

    public String[] stanza5 = {
            "Jina lake Yesu tamu;\nTukilisikia\nHutupoza, tena hamu\nHutuondolea",
            "Roho iliyoumia\nKwalo hutibika,\nChakula, njaani pia;\nRaha, tukichoka.",
            "Jina hili ni msingi,\nNgao, ngome, mwanga\nKwa hili napata wingi\nKwangu ni akiba",
            "Yesu, Mchunga, Rafiki,\nMwalimu, Kuhani,\nMwanzo, Mwisho, Njia,\nHaki, uzima kifoni",
            "Moyo wangu hauwezi\nKukusifu kweli,\nIla sifa zangu hizi,\nBwana zikubali.",
            "Na utakaponiita,\nKuja kwako Bwana,\nHuko kwako sitaacha\nKukusifu sana."
    };
    public String[] stanza6 = {
            "Baba, Mwana, Roho, Mungu mwenye enzi,\nKila tukiamka tunakuabudu\nBaba, Mwana, Roho, Mungu wa mapenzi,\nEwe Utatu, tunakusifu",
            "Baba, Mwana, Roho wakuaminio\nWanakutolea shukrani zao.\nWakusujudia malaika nao:\nWewe u mwanzo, nawe u mwisho ",
            "Baba, Mwana, Roho, sisi tu gizani,\nUtukufu wako hauoni kosa;\nU Mtakatifu, nawe u mapenzi,\nU peke yako, mwenzio huna",
            "Baba, Mwana, Roho, Mungu mwenye enzi,\nUlivyoviumba vyote vyakusifu:\nBaba, Mwana, Roho, Mungu wa mapenzi,\nEwe Utatu, tunakusifu"
    };

    public String[] stanza7 = {
            "Ni tabibu wa karibu; \ntabibu wa ajabu;\nna rehema za daima; \nni dawa yake njema.\n ",
            "Imbeni, malaika, \nsifa za Yesu Bwana;\npweke limetukuka \njina lake Yesu.\n",
            "Hatufai kuwa hai, \nwala hatutumai,\nila yeye kweli ndiye \natupumzishaye.\n",
            "Dhambi pia na hatia \nametuchukulia;\nTwenendeni na amani \nhata kwake mbinguni.\n",
            "Huliona tamu jina, \nla Yesu kristo Bwana,\nyuna sifa mwenye kufa \nasishindwe na kufa.\n",
            "Kila mume asimame, \nsifa zake zivume;\nWanawake na washike \nkusifu jina lake.\n",
            "Na vijana wote tena, \nwampendao sana,\nwaje kwake wawe wake \nkwa utumishi wake.\n"
    };

    public String[] stanza8 = {
            "Taji mvikeni,\nTaji nyingi tena,\nKondoo mwake Kitini,\nBwana wa mabwana:\nNami tamsifu\nAlikufa kwangu,\nNi Mfalme mtukufu,Mkuu wa Mbingu",
            "Taji mvikeni,\nMwana wa bikira;\nAnazovaa kichwani\nAliteka nyara;\nShiloh wa wanabii,\nMchunga wa watu,Shina na tanzu vya\nYese,\nWa Bethilehemu",
            "Taji mvikeni,\nBwana wa mapenzi,\nJeraha zake ni shani\nNa vito vya enzi,\nMbinguni hakuna\nHata malaika\nAwezaye kuziona\nPasipo kushangaa."
    };

    public String[] stanza9 = {
            "Yesu kwetu ni rafiki, \nhwambiwa haja pia; \ntukiomba kwa Babaye, \nmaombi asikiya; \nLakini twajikosesha, \ntwajitweka vibaya; \nkwamba tulimwomba \nMungu, \ndua angesikia. \n",
            "Una dhiki na maonjo? \nUna mashaka pia. \nHaifai kufa moyo, \ndua atasikia. \nHakuna mwingine \nmwema,\nwa kutuhurumia; \natujua tu dhaifu; \nmaombi asikia.\n",
            "Je hunayo hata nguvu, \nhuwezi kwendelea, \nujapodharauliwa, \nujaporushwa pia. \nWatu wangekudharau, \nwapendao dunia, \nhukwambata \nmikononi, \ndua atasikia.\n"
    };
    public String[] stanza10 = {
            "Usinipite mwokozi,\nunisikie;\nunapozuru wengine \nusinipite \n",
            "Yesu, Yesu, \nunisikie;\nunapozuru wengine, \nusinipite\n",
            "Kiti chako cha rehema, \nnakitazama;\nMagoti napiga pale, \nnisamehewe.\n",
            "Sina ya kutegemea, \nila wewe tu;\nUso wako uwe kwangu; \nNakuabudu.\n",
            "U mfariji peke yako; \nsina Mbinguni,\nwala duniani pote, \nBwana mwingine.\n"
    };
    public String[] stanza11 = {
            "Nina haja nawe \nkila saa; \nhawezi mwingine \nkunifaa. \n",
            "Yesu, nakuhitaji \nvivyo kila saa! \nNiwezeshe, mwokozi, \nnakujia\n",
            "Nina haja nawe; \nkaa nami, \nna maonjo haya, \nhayaumi.\n",
            "Nina haja nawe; \nkila hali, \nmaisha ni bure, \nuli mbali.\n",
            "Nina haja nawe; \nnifundishe \nna ahadi zako, \nzifikishe.\n",
            "Nina haja nawe; \nmweza yote, \nni wako kabisa \nsiku zote."
    };
    public String[] stanza12 = {
            "Ewe Roho wa Mbinguni\nUje kwetu sasa.\nUfanye makazi yako\nNdani ya kanisa",
            "Ndiwe mwanga umulike,\nTupate jikana;\nMengi kwetu yapunguka,\nTujalize, Bwana.",
            "Ndiwe Moto, teketeza\nTaka zetu zote:\nMoyo na iwe sadaka\nYa mwokozi, yote",
            "Ndiwe Umande, na kwako\ntutaburudika,\nNchi kavu itakuwa\nNi yenye baraka",
            "Roho wa Mbinguni uwe\nNasi hapa chini,\nMwili uufananishe\nNa Kichwa Mbinguni"
    };
    public String[] stanza13 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };
    public String[] stanza14 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };
    public String[] stanza16 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };
    public String[] stanza17 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };
    public String[] stanza18 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };
    public String[] stanza19 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };
    public String[] stanza20 = {
            "Tafuta daima utakatifu:\nFanya urafiki na Wakristo tu;\nNena siku zote na Bwana wako;\nBaraka uombe kwa kila jambo",
            "Tafuta daima utakatifu:\nUwe peke yako ukimwabudu:\nUkimwangalia Mwokozi wako,\nUtabadilishwa kama alivyo",
            "Tafuta daima utakatifu:\nKiongozi wako awe Yesu tu,\nKatika furaha au huzuni\nDumu kumfuata Yesu Mwokozi.",
            "Tafuta daima utakatifu:\nUmtazame Roho moyoni mwako;\nAkikuongoza katika haki,\nHufanywa tayari kwa kazi yake"
    };

    public ListviewObjects [] values;

    public List<String[]> pList;

    public List<String[]> mList;


    /**
     * End Of The Songs
     */



    public final int REPORT_RESULT = 1;

    ListView contentFrame;

    public static String[] songList;

    public static String[] englishTitles;

    public static String[] songReferences;

    public String songTitle;

    public int count;

    public static ListviewObjects[] items;

    public static Typeface Athletic, Fun_Raiser, Roboto_Condensed, Roboto_Black, Roboto_Light, Roboto_BoldCondensedItalic, Roboto_BoldCondensed, Rosario_Regular, Rosario_Bold, Rosario_Italic, Roboto_Regular, Roboto_Medium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        getActionBar().setDisplayShowTitleEnabled(true);



        mList = new ArrayList<String[]>();
        mList.add(stanza1);
        mList.add(stanza2);
        mList.add(stanza3);
        mList.add(stanza4);
        mList.add(stanza5);
        mList.add(stanza6);
        mList.add(stanza7);
        mList.add(stanza8);
        mList.add(stanza9);
        mList.add(stanza10);
        mList.add(stanza11);
        mList.add(stanza12);
        mList.add(stanza13);
        mList.add(stanza14);
        mList.add(stanza15);
        mList.add(stanza16);
        mList.add(stanza17);
        mList.add(stanza18);
        mList.add(stanza19);
        mList.add(stanza20);

        pList = new ArrayList<String[]>();
        pList.add(stanza_tags1);
        pList.add(stanza_tags2);
        pList.add(stanza_tags3);
        pList.add(stanza_tags4);
        pList.add(stanza_tags5);
        pList.add(stanza_tags6);
        pList.add(stanza_tags7);
        pList.add(stanza_tags8);
        pList.add(stanza_tags9);
        pList.add(stanza_tags10);
        pList.add(stanza_tags11);
        pList.add(stanza_tags12);
        pList.add(stanza_tags13);
        pList.add(stanza_tags14);
        pList.add(stanza_tags15);
        pList.add(stanza_tags16);
        pList.add(stanza_tags17);
        pList.add(stanza_tags18);
        pList.add(stanza_tags19);
        pList.add(stanza_tags20);

        /**
         * Type faces used for setting fonts thoughout the app
         */
        Roboto_Light = Typeface.createFromAsset(this.getAssets(), "Roboto-Light.ttf");
        Roboto_Black = Typeface.createFromAsset(this.getAssets(), "Roboto-Black.ttf");
        Roboto_Condensed = Typeface.createFromAsset(this.getAssets(), "Roboto-Condensed.ttf");
        Roboto_BoldCondensedItalic = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensedItalic.ttf");
        Roboto_BoldCondensed = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensed.ttf");
        Roboto_Regular = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
        Roboto_Medium = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        Rosario_Regular = Typeface.createFromAsset(getAssets(), "Rosario-Regular.ttf");
        Rosario_Italic = Typeface.createFromAsset(getAssets(), "Rosario-Italic.ttf");
        Rosario_Bold = Typeface.createFromAsset(getAssets(), "Rosario-Bold.ttf");


        contentFrame = (ListView)findViewById(R.id.content_frame);

        LayoutInflater inflater = (LayoutInflater) MainActivity.this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View mainActivityListHeader;

        mainActivityListHeader = inflater.inflate(R.layout.mainactivity_item_list_header, null);

        contentFrame.addHeaderView(mainActivityListHeader);

        songList = getResources().getStringArray(R.array.titoes);

        englishTitles = getResources().getStringArray(R.array.english_titles);

        songReferences = getResources().getStringArray(R.array.song_references);

        items = new ListviewObjects[songList.length];

        int x = 0;

        for(int i=0; i<songList.length; i++){

            if ((i == 99) || (i == 222) || (i == 176)){
                x++;
                items[i] = new ListviewObjects(songList[i], 1, englishTitles[i], songReferences[i]);
                items[i].setObjectPosition(i);
            }
            else{
                items[i] = new ListviewObjects(songList[i], 0, englishTitles[i], songReferences[i]);
                items[i].setObjectPosition(i);
            }

            items[i].setStanza(mList.get(i));
            items[i].setStanzatag(pList.get(i));

        }

        contentFrame.setAdapter(new gridViewAdapter(this, R.id.item_title, items));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.launcher, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle your other action bar items...
        if(item.getItemId() == R.id.launcher){
            Intent intent = new Intent(MainActivity.this, SelectionGridActivity.class);
            //Bundle translateBundle = ActivityOptions.makeCustomAnimation(this, R.anim.animslideright, R.anim.animslideleft).toBundle();
            MainActivity.this.startActivityForResult(intent, REPORT_RESULT);
            //SelectionGridActivity.update(SelectionGridActivity, SelectionGridActivity.listToArray(SelectionGridActivity.mSongsFiltered));
            //Toast.makeText(MainActivity.this, "option menu selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REPORT_RESULT) {
            if (resultCode == RESULT_OK) {
                // code for result
                final Bundle bundle = data.getExtras();
                count = bundle.getInt("tag");

                if(count != -1) {
                    Intent cardDetail = new Intent(MainActivity.this, SongDetails.class);
                    cardDetail.putExtra("itemPosition", count);
                    Bundle translateBundle = ActivityOptions.makeCustomAnimation(MainActivity.this, R.anim.activity_slide_in_left, R.anim.activity_slide_out_left).toBundle();
                    MainActivity.this.startActivity(cardDetail, translateBundle);
                }
            }
            if (resultCode == RESULT_CANCELED) {
                // Write your code on no result return
            }
        }
    }

}
