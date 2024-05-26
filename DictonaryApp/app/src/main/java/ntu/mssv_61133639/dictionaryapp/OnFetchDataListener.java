package ntu.mssv_61133639.dictionaryapp;

import ntu.mssv_61133639.dictionaryapp.Models.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse, String message);
    void onError (String message);
}
