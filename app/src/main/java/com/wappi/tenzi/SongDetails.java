package com.wappi.tenzi;

import android.app.Activity;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

import Transformers.DepthPageTransformer;
import adapter.MyPagerAdapter;
import adapter.viewPagerAdapter;

/**
 *  Created by isaiah on 10/28/2014.
 */
public class SongDetails extends Activity {

    public int position;

    public static boolean loaded = false;

    private String[] mTitles;

    public String [] values;

    public String[] stanza_tags1 = {"verse" ,"chorus", "verse", "verse","verse","verse","verse","verse"};
    public String[] stanza1 = {
            "Mwokozi Umeokoa \nNimekua wako wewe,\nDamu imenisafisha \nSifa kwa mwana kondoo\n",
            "Utukufu Aleluya \nSifa kwa mwana \nkondoo\nDamu imenisafisha\n Utukufu kwa Yesu\n",
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
    public String[] stanza_tags14 = {};
    public String[] stanza_tags16 = {};
    public String[] stanza_tags17 = {};
    public String[] stanza_tags18 = {};
    public String[] stanza_tags19 = {};
    public String[] stanza_tags20 = {};

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
    public String[] stanza14 = {};
    public String[] stanza16 = {};
    public String[] stanza17 = {};
    public String[] stanza18 = {};
    public String[] stanza19 = {};
    public String[] stanza20 = {};


    public String value_changer;

    public static ActionBar actionBar;

    public List<String[]> pList;

    public List<String[]> mList;

    viewPagerAdapter pager_adapter;

    MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_details);
        final Bundle bundle=getIntent().getExtras();

        values=bundle.getStringArray("allValues");
        position=bundle.getInt("itemPosition");
        value_changer=bundle.getString("changer");

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

        mTitles = getResources().getStringArray(R.array.titoes);

        actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        final ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setPageTransformer(true, new DepthPageTransformer());
        myPagerAdapter = new MyPagerAdapter(this, values, mList, pList);
        pager.setAdapter(myPagerAdapter);
        pager.setCurrentItem(position);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                loaded = false;
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

}
