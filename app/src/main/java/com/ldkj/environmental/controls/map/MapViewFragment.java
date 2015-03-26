package com.ldkj.environmental.controls.map;

import android.app.Fragment;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapFragment;
import com.amap.api.maps.MapView;
import com.ldkj.environmental.R;

/**
 * Created by john on 15-3-25.
 */
public class MapViewFragment extends Fragment {

    private MapViewFragmentCallback callback;
    private MapView mapView;
    private AMap    aMap;


    public MapViewFragment(MapViewFragmentCallback callback){
        this.callback = callback;
    }
    public MapViewFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_map,null);
        mapView = (MapView) _view.findViewById(R.id.fragment_map_view);
        mapView.onCreate(savedInstanceState);

        initMap();


        return _view;
    }


    private void initMap(){
        aMap = mapView.getMap();
        aMap.getUiSettings().setCompassEnabled(true);
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mapView.onResume();

        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }



}

