package com.lanou3g.mostbeauty.Bean;

import android.support.v4.app.Fragment;

import com.lanou3g.mostbeauty.fragment.PictorialProductionFragment;
import com.lanou3g.mostbeauty.fragment.PictorialSmallFragment;
import com.lanou3g.mostbeauty.fragment.PictorialStoreFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/3.
 */
public class PivtorialAnthorInfo {
    private String title;
    private Fragment fragment;

    public PivtorialAnthorInfo(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }
    public static List<PivtorialAnthorInfo> getTabInfos(){
        List<PivtorialAnthorInfo> infos = new ArrayList<>();
        infos.add(new PivtorialAnthorInfo("作品",new PictorialProductionFragment()));
        infos.add(new PivtorialAnthorInfo("画报",new PictorialSmallFragment()));
        infos.add(new PivtorialAnthorInfo("旗舰门店",new PictorialStoreFragment()));
        return infos;
    }
}
