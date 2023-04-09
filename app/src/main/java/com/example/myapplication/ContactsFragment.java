package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    RecyclerView recyclerView;
//    MyAdapter myAdapter;

    private RecyclerView recyclerView;
    private List<Map<String,Object>> data;
    private Context context;
    private MyAdapter3 myadapter3;
    public ContactsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContractsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactsFragment newInstance(String param1, String param2) {
        ContactsFragment fragment = new ContactsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view;
//        view = inflater.inflate(R.layout.contacts, container, false);
//        recyclerView = view.findViewById(R.id.recycler_view);
//
//        ArrayList<String> data = new ArrayList<String>();
//        for (int i =0;i <10; i++) {
//            data.add("这是第" + i + "个测试");
//        }
//
//        Context context = getContext();
//        myAdapter = new MyAdapter(data,context);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
//        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(myAdapter);
//        return view;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts, container, false);
        context = view.getContext();

        recyclerView = view.findViewById(R.id.recycler_view);
        data = new ArrayList<Map<String,Object>>();

        String [] title = {"全球范围内开始接种COVID-19疫苗",
                "拜登签署1.9万亿美元的COVID-19救济法案",
                "中国发射首个空间站模块",
                "乔治·弗洛伊德家庭达成2700万美元的民事和解协议",
                "英国宣布计划到2030年禁止销售汽油和柴油车",
                "NASA的毅力号探测器成功着陆火星",
                "缅甸军方发动政变，政府领袖被拘留",
                "美国股市上涨，标普500指数首次突破4000点",
                "日本地震导致福岛核电站附近的海域发生海啸",
                "明尼阿波利斯警方开枪打死达恩特·莱特，引发抗议"};
        String [] introduce = {"全球各地开始接种COVID-19疫苗，以控制新冠病毒传播和缓解疫情对社会和经济的影响。",
                "美国总统拜登签署了一项总额为1.9万亿美元的COVID-19救济法案，旨在提供财政援助和支持疫苗接种。",
                "中国成功发射首个空间站核心模块，标志着中国空间站计划的重要进展。",
                "乔治·弗洛伊德的家人与明尼阿波利斯市议会达成了一项2700万美元的民事和解协议。",
                "英国宣布计划到2030年禁止销售汽油和柴油车，以推动更环保的交通方式。",
                "NASA的毅力号探测器成功着陆火星，开始进行探测和研究工作。",
                "缅甸军方发动政变，政府领袖昂山素季被拘留，引发国内外的广泛关注和谴责。",
                "美国股市上涨，标普500指数首次突破4000点，反映出投资者对美国经济复苏的信心。",
                "日本地震导致福岛核电站附近的海域发生海啸，但核电站并未报告任何异常情况。",
                "明尼阿波利斯警方开枪打死达恩特·莱特，引发了该地区的抗议和骚乱。"};
        String [] detail = {"从2020年12月开始，一些国家已经开始接种COVID-19疫苗，首先是英国、美国、以色列等国家。目前，全球范围内已经有数百万人接种了COVID-19疫苗，并且疫苗接种计划在许多国家和地区仍在继续进行。接种疫苗是控制病毒传播和缓解疫情对社会和经济的影响的一个重要措施，同时也为恢复经济和恢复正常生活提供了希望。",
                "美国总统拜登签署了一项总额为1.9万亿美元的COVID-19救济法案，这是美国历史上规模最大的一项救济措施。该法案旨在提供各种形式的财政援助，包括对失业和贫困家庭的经济支持、对小企业的财政援助以及对学校和医疗机构的资金支持。此外，该法案还为COVID-19疫苗接种提供了大量的资金支持，旨在帮助加速全美范围内的疫苗接种进程。这项法案被认为是应对COVID-19疫情和缓解其对经济造成的影响的一项重要措施。",
                "中国成功发射了首个空间站核心模块“天和”，这是中国空间站计划的重要组成部分。该模块重约22.5吨，直径约16.6米，可以提供舱内居住和科学实验等功能。中国计划在未来几年内发射更多的空间站模块，并组装成完整的空间站。这将使中国成为第三个能够拥有自己空间站的国家，仅次于美国和俄罗斯。该计划也被视为中国在航天领域追赶和超越其他国家的重要一步。",
                "2020年5月，乔治·弗洛伊德在明尼阿波利斯被警方拘捕时身亡，引发了全球范围内对警方暴力执法和种族不平等的抗议。近日，乔治·弗洛伊德的家人与明尼阿波利斯市议会达成了一项2700万美元的民事和解协议，结束了他们对市政府的诉讼。这项协议也包括一系列针对警方的改革措施，旨在防止类似事件再次发生。该协议是目前为止美国历史上最高额的警方死亡赔偿和解协议之一，也被认为是对警方执法行为的一项重要改革。",
                "英国政府宣布计划到2030年禁止销售汽油和柴油车，以推动更环保的交通方式。此外，政府还宣布了一项10亿英镑的资金计划，用于支持汽车制造商和其他公司开发和生产新型电动汽车和充电基础设施。这项计划是英国政府旨在实现“零碳排放”目标的一部分，同时也是对环境问题的一项重要举措。这一决定得到了环保组织和其他利益相关者的广泛欢迎，但也引起了一些担忧，包括对汽车制造业和相关就业岗位的影响。",
                "2021年2月18日，NASA的毅力号探测器成功着陆火星，这是NASA历史上第五次成功着陆火星。毅力号探测器的主要任务是在火星上寻找生命的迹象，它将使用一系列科学仪器来研究火星的气候、地质和化学成分，并收集土壤和岩石样本，以寻找火星生命存在的证据。此次任务预计将持续至少两年，期间将进行大量的探测和研究工作。毅力号探测器的着陆标志着人类在火星上开展探测和研究工作的又一重要里程碑，也为未来可能的人类登陆火星奠定了重要基础。",
                "2021年2月1日，缅甸军方突然发动政变，宣布解散国民大会和政府，并宣布进入为期一年的紧急状态。政变发生后，缅甸军方拘留了政府领袖昂山素季和其他政府高官，引发了国内外的广泛关注和谴责。国际社会对此表示强烈谴责，呼吁缅甸军方立即释放被拘留的政府官员，并恢复民主秩序。政变发生后，缅甸各地出现了一系列的抗议活动，要求恢复民主制度。缅甸局势目前依然不稳定，国际社会也在密切关注事态的发展。",
                "2021年4月1日，美国股市上涨，标普500指数首次突破4000点，这是标普500指数历史上的一个重要里程碑。此次上涨反映出投资者对美国经济复苏的信心，尤其是在COVID-19疫苗的推广和经济刺激计划的实施之后。美国政府最近通过了一项1.9万亿美元的救济计划，旨在刺激经济增长并帮助COVID-19疫情受影响的人们。此外，随着COVID-19疫苗的推广和经济逐渐复苏，投资者对未来经济增长的前景也越来越乐观，这也促使了股市的上涨。不过，需要注意的是，股市上涨也带来了一定的风险，包括市场波动和投资风险等。",
                "2021年3月20日，日本东北部地区发生6.9级地震，导致福岛核电站附近的海域发生海啸。据报道，福岛核电站并未报告任何异常情况，核电站运营商东京电力公司称，核电站的防洪墙没有受到破坏，且地震和海啸对核电站的影响非常有限。福岛核电站曾在2011年的地震和海啸中遭受了重大破坏，导致核泄漏和大规模疏散。此次地震和海啸引发了人们对福岛核电站的担忧，但据报道，核电站目前的状况稳定，没有出现任何异常情况。不过，日本地震和海啸的灾害性仍然值得关注，日本位于环太平洋地震带上，地震和海啸是常见自然灾害。",
                "2021年4月11日，明尼阿波利斯警方在一次交通检查中开枪打死了20岁的黑人男子达恩特·莱特。据警方称，当时他们试图逮捕莱特，但他从车里跑出来，警方认为他可能持有武器，因此开枪射击。事后，警方确认莱特并未持有武器。这起事件引起了明尼阿波利斯市民的强烈反对和抗议，抗议者聚集在警察局外，要求对警察进行起诉和问责。在接下来的几天里，该地区爆发了大规模的骚乱和抗议活动，警察局遭到了破坏和纵火。这起事件引发了美国各地的抗议活动，许多人要求对警察进行更严格的监管和改革。这也是自2020年乔治·弗洛伊德之死以来，美国再次发生类似事件所引发的抗议和社会动荡。"};
        int[] image ={R.raw.news1,R.raw.news2,R.raw.news3,R.raw.news4,R.raw.news5,
                R.raw.news6,R.raw.news7,R.raw.news8,R.raw.news9,R.raw.news10};
        for (int i=0;i<title.length;i++)
        {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("标题",title[i]);
            map.put("简介",introduce[i]);
            map.put("头像",image[i]);
            map.put("介绍",detail[i]);
            data.add(map);
        }

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        myadapter3 = new MyAdapter3(context,data);
        recyclerView.setAdapter(myadapter3);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));//添加下划线
        return view ;
    }

}