package com.melody.base;

import android.Manifest;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class BasePermissionActivity extends AppCompatActivity {

    public static final String PERMISSION_TAKE_PHOTO = "take_photo";
    public static final String PERMISSION_TAKE_VIDEO = "take_video";
    public static final String PERMISSION_TAKE_AUDIO = "take_audio";
    public static final String PERMISSION_STORAGE = "storage";

    public void showWithCheck(String permissionType) {
        switch (permissionType) {
            case PERMISSION_TAKE_PHOTO:
                BasePermissionActivityPermissionsDispatcher.showTakePhotoWithPermissionCheck(this);
                break;
            case PERMISSION_TAKE_VIDEO:
                BasePermissionActivityPermissionsDispatcher.showTakeVideoWithPermissionCheck(this);
                break;
            case PERMISSION_TAKE_AUDIO:
                BasePermissionActivityPermissionsDispatcher.showTakeAudioWithPermissionCheck(this);
                break;
            case PERMISSION_STORAGE:
                BasePermissionActivityPermissionsDispatcher.showStorageWithPermissionCheck(this);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        BasePermissionActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void showRationaleDialog(String permissionName, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage("需要获取使用" + permissionName + "权限！")
                .show();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void showSuccessToast(String permissionName) {
        showToast("已获取" + permissionName + "权限");
    }

    private void showDeniedToast(String permissionName) {
        showToast("您已拒绝开启" + permissionName + "权限，请允许权限后重试！");
    }

    private void showNeverAskToast(String permissionName) {
        showToast("您已拒绝" + permissionName + "权限，请到权限管理中心开启该权限后重试！");
    }

    //******************** 拍照权限（摄像头、sd读权限、sd写权限） ******************************************************

    // 给予权限时会执行该方法
    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    public void showTakePhoto() {
        showSuccessToast("相机及存储");
    }

    // 向用户解释为什么需要调用该权限的方法上，只有当第一次请求权限被用户拒绝，下次请求权限之前会调用
    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void showRationaleForTakePhoto(PermissionRequest request) {
        showRationaleDialog("相机及存储", request);
    }

    // 当用户拒绝了权限请求时需要调用的方法上
    @OnPermissionDenied({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onTakePhotoDenied() {
        showDeniedToast("相机/存储");
    }

    // 当用户选中了授权窗口中的不再询问复选框后并拒绝了权限请求时需要调用的方法，一般可以向用户解释为何申请此权限，并根据实际需求决定是否再次弹出权限请求对话框
    @OnNeverAskAgain({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onTakePhotoNeverAskAgain() {
        showNeverAskToast("相机/存储");
    }
    //******************** 录音权限（录音、sd读权限、sd写权限） ******************************************************

    @NeedsPermission({Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    public void showTakeAudio() {
        showSuccessToast("录音及存储");
    }

    @OnShowRationale({Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void showRationaleForTakeAudio(PermissionRequest request) {
        showRationaleDialog("录音及存储", request);
    }

    @OnPermissionDenied({Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onTakeAudioDenied() {
        showDeniedToast("录音/存储");
    }

    @OnNeverAskAgain({Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onTakeAudioNeverAskAgain() {
        showNeverAskToast("录音/存储");
    }

    //******************** 录像权限（摄像头、录音、sd读权限、sd写权限） ******************************************************

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    public void showTakeVideo() {
        showSuccessToast("相机、录音及存储");
    }

    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void showRationaleForTakeVideo(PermissionRequest request) {
        showRationaleDialog("相机、录音及存储", request);
    }

    @OnPermissionDenied({Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onTakeVideoDenied() {
        showDeniedToast("相机/录音/存储");
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onTakeVideoNeverAskAgain() {
        showNeverAskToast("相机/录音/存储");
    }

    //******************** 存储权限（sd读权限、sd写权限） ******************************************************

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    public void showStorage() {
        showSuccessToast("存储");
    }

    @OnShowRationale({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void showRationaleForStorage(PermissionRequest request) {
        showRationaleDialog("存储", request);
    }

    @OnPermissionDenied({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onStorageDenied() {
        showDeniedToast("存储");
    }

    @OnNeverAskAgain({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onStorageNeverAskAgain() {
        showNeverAskToast("存储");
    }

}
