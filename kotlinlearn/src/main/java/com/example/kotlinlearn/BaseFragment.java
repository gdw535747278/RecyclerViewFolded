/*
package com.example.kotlinlearn;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avast.android.dialogs.fragment.ProgressDialogFragment;
import com.avast.android.dialogs.fragment.SimpleDialogFragment;
import com.avast.android.dialogs.iface.ISimpleDialogCancelListener;
import com.avast.android.dialogs.iface.ISimpleDialogListener;
import com.rosevision.ofashion.BuildConfig;
import com.rosevision.ofashion.R;
import com.rosevision.ofashion.activity.BaseActivity;
import com.rosevision.ofashion.activity.BaseWithoutActionBarLogicActivity;
import com.rosevision.ofashion.activity.OFashionApplication;
import com.rosevision.ofashion.constants.ConstantsRoseFashion;
import com.rosevision.ofashion.model.base.BaseOriginal;
import com.rosevision.ofashion.model.bean.OFashionLogCurrentPage;
import com.rosevision.ofashion.model.bean.OFashionLogExtension;
import com.rosevision.ofashion.model.event.DummyEvent;
import com.rosevision.ofashion.retrofit.service.AllService;
import com.rosevision.ofashion.retrofit.service.PostService;
import com.rosevision.ofashion.util.AppUtils;
import com.rosevision.ofashion.util.LogUtil;
import com.rosevision.ofashion.util.OFFileLogger;
import com.rosevision.ofashion.util.ToastUtil;
import com.rosevision.ofashion.util.ViewUtility;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Date;

import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import rx.subscriptions.CompositeSubscription;

*/
/**
 * 这是程序所有Fragment的基类，这意味着在本程序里所有的Fragment要么直接继承BaseFragment，
 * 要么继承BaseFragment的子类。它会做一些关于友盟统计相关的工作，并且提供一些常用的公共方法提供被子类调用，
 * 比如显示ProgressBar。关于BaseFragment，有如下几点需要注意：
 * <p>
 * 1，什么时候子类不可以直接继承BaseFragment？
 * 如果子类不是直接根据Activity传递过来的参数来显示具体的内容，
 * 这种子类不应该直接继承BaseFragment。因为因为BaseFragment不提供任何关于EmptyView的逻辑，
 * 而每当Fragment需要先从服务器去加载数据之后然后再来显示内容的时候，
 * 我们需要先显示一个EmptyView，等数据加载成功之后再来显示服务器返回的内容。
 * 这种情况，我们应该继承BaseLoadingFragment，具体使用案例请参考DetailSpecialFragment。
 * <p>
 * <p>
 * <p>
 * 2，什么时候子类可以直接继承BaseFragment？
 * 如果子类是直接根据Activity传递过来的参数来显示具体的内容,而不需要先从服务器去加载数据，
 * 子类应该直接继承BaseFragment。具体的参考案例有请参考ModifyPasswordFragmentV2。
 * <p>
 * <p>
 * 3，BaseFragment可以发送Post请求吗？
 * BaseFragment可以发送Post请求，因为BaseFragment里面提供了showProgress和hideProgress的方法。
 * 我们可以在发送请求之前先调用showProgress，请求成功之后再去调用hideProgress
 * 具体的参考案例有ModifyPasswordFragment.java
 *//*

public abstract class BaseFragment extends Fragment implements ISimpleDialogListener,
        ISimpleDialogCancelListener {

    //下面两个两个变量的存在主要是为了避免当网络出现异常的时候，我们的Toast会持续显示两次或者两次以上的时间。通过记录上一次的显示时间，我们可以判断如果在一定时间以内（d当前设置为3秒钟以内）网络又不正常或者出现错误的话，那么我们就不显示新的Toast。
    public static final int TOAST_DURATION = 3000;//一个Toast显示的持续时间。单位为毫秒。
    private static long timeStampForLastToast;//上一个Toast显示的时刻
    protected final CompositeSubscription compositeSubscription = new CompositeSubscription();
    public ViewGroup rootView;
    public String customTimeStamp;
    protected boolean isCreated = false;
    protected boolean isDestroyed;
    private DialogFragment dialogFragment;


//    ————>fragment入口
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //在Fragment被创建之后，为所有的Fragment注册EventBus的监听事件。
        if (shouldRegisterOrUnregisterEventBus()) {
            EventBus.getDefault().register(this);
        }
        super.onCreate(savedInstanceState);
        initValue();// ————>用于子类在这个生命周期做的一些逻辑  因为是抽象方法 所以子类必须重写
//        getParamsCurrentPageId();
        isCreated = true;
    }

//    public void getParamsCurrentPageId() {
//        AppUtils.setPageId(getCurrentPageId());
//    }

    @Subscribe
    public void subscribeDummyEvent(DummyEvent event) {

        LogUtil.d("BaseFragment subscribe DummyEvent to ensure event bus works ok::: ");
    }

//    ————>fragment声明周期用来加载界面布局的
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(inflateLayout(), container, false);
        ButterKnife.bind(this, rootView);
        init();// ————>用于子类在这个生命周期做的一些逻辑  用的时候重写 不用的时候不用管
        return rootView;
    }

//    ————>fragment生命周期 界面可操作的时候会调用这个方法
//    ————>这个方法里的东西判断了啥我也看不明白 在OFashionLogCurrentPage这个类里 你也估计用不到
    @Override
    public void onResume() {
        super.onResume();
        this.customTimeStamp = OFFileLogger.myLogSdf.format(new Date());
        if (getOFashionLogCurrentPage() != null) {
            OFashionLogCurrentPage currentPage = getOFashionLogCurrentPage();
            OFFileLogger.newInstance().setOFashionLogMetadata(OFFileLogger.LOG_TYPE_ENTRANCE);
            OFashionLogExtension extension = getOFashionLogExtension();
            if (!TextUtils.isEmpty(OFFileLogger.newInstance().getNotificationProtocol())) {
                if (extension == null) {
                    extension = new OFashionLogExtension.OFashionLogExtensionNewBuilder()
                            .notificationProtocol(OFFileLogger.newInstance().getNotificationProtocol()).create();
                } else {
                    extension.setNotification_protocol(OFFileLogger.newInstance().getNotificationProtocol());
                }
                OFFileLogger.newInstance().setNotificationProtocol(null);
            }
            currentPage.setExtension(extension);
            currentPage.getApp_start_type();
            OFFileLogger.newInstance().setOFashionLogCurrentPage(currentPage);
            AppUtils.saveOFashionLogInfoNew(OFFileLogger.newInstance().getOFashionLogInfoNew());
            OFFileLogger.newInstance().setOFashionLogOperationInfo(null);
        }
    }

    public OFashionLogExtension getOFashionLogExtension() {
        return null;
    }

//    ————>fragment生命周期 页面不可操作的时候被调用，里面做的也和你没关系  好像是做统计用的
    @Override
    public void onPause() {
        super.onPause();
        if (OFFileLogger.newInstance().getCurrentPage() != null) {
            OFFileLogger.newInstance().saveCurrentPageChangeId();
            OFFileLogger.newInstance().setOFashionLogMetadata(OFFileLogger.LOG_TYPE_ENTRANCE);
            OFFileLogger.newInstance().getCurrentPage().setPage_stay_time(OFFileLogger.newInstance().getPageStayTime(customTimeStamp));
            OFFileLogger.newInstance().setOFashionLogCurrentPage(OFFileLogger.newInstance().getCurrentPage());
            OFFileLogger.newInstance().setOFashionLogRefer();
        }
    }

    public OFashionLogCurrentPage getOFashionLogCurrentPage() {
        if (getCurrentPageId() == null) {
            return null;
        }
        OFashionLogCurrentPage currentPage = new OFashionLogCurrentPage.OFashionLogCurrentPageNewBuilder()
                .pageId(getCurrentPageId())
                .pageEntranceTime(OFFileLogger.newInstance().getServerCheckTime(customTimeStamp)).create();
        return currentPage;
    }

    public abstract String getCurrentPageId();

//    ————>在onCreate被调用，不是抽象类 子类不是必须重写，需要的时候调用
    public void init() {

    }

    public void setCustomTitle(@StringRes int stringResourceId) {

        ((BaseActivity) getActivity()).setCustomTitle(stringResourceId);
    }

    public void setCustomTitle(String title) {
        ((BaseActivity) getActivity()).setCustomTitle(title);
    }

//    ————>onCreateView之后被调用
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();//————>抽象方法 子类必须重写 里面可以做一些UI方面的逻辑
        postInit();//————>看名字是用来处理请求的 不是抽象类不用重写
    }

    */
/**
     * 处理网络请求错误相关逻辑
     *//*

    @DebugLog
    public void onServiceGeneralError(Throwable throwable) {
        hideProgress();
        if (BuildConfig.DEBUG) {
            throwable.printStackTrace();
        }
        onLoadError();
    }

    protected void postInit() {
    }

    public void invalidateOptionsMenu() {
        getActivity().invalidateOptionsMenu();
    }

//    ————>用于子类传布局id的，在onCreateView方法里被调用
    protected abstract int inflateLayout();

    protected abstract void initValue();

    protected abstract void initUI();


    public void onAuthInvalid(BaseOriginal.AuthInfo authInfo) {
        ViewUtility.showEaseMobActionRequiredDialog(getActivity(), authInfo.getMsg(), ((BaseWithoutActionBarLogicActivity) getActivity()).expectedToSigned());
    }

    */
/**
     * 处理网络请求错误相关逻辑
     *//*

    protected void onLoadError() {
        preOnLoadError();//统一处理共同的网络错误逻辑。
        postOnLoadError();//让子类去重载来处理子类自定义业务逻辑。
    }

    */
/**
     * 提供方法让子类去重载来处理子类自定义业务逻辑。
     *//*

    public void postOnLoadError() {
    }


    public boolean shouldRegisterOrUnregisterEventBus() {
        return true;
    }

    */
/**
     * 统一处理共同的网络错误逻辑。
     *//*

    private void preOnLoadError() {
        hideProgress();
        long currentTimeStamp = System.currentTimeMillis();
        //如果上一个Toast是在三秒钟之内显示的，那么我们就不显示新的Toast
        if (timeStampForLastToast == 0 || currentTimeStamp - timeStampForLastToast > TOAST_DURATION) {
            if (couldShowNetworkErrorToast()) {
                showNetworkErrorToast(currentTimeStamp);
            }

        }
    }

    protected boolean couldShowNetworkErrorToast() {
        return true;
    }

    private void showNetworkErrorToast(long currentTimeStamp) {
        timeStampForLastToast = currentTimeStamp;
        ToastUtil.showToast(AppUtils.isConnected() ? R.string.server_error : R.string.no_network);
    }

    @Override
    public void onDestroy() {
        //在Fragment被销毁之前，为所有的Fragment取消注册EventBus的监听事件
        if (shouldRegisterOrUnregisterEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    */
/**
     * 显示Progress Dialog
     *
     * @param resID Dialog里显示的String的资源ID
     *//*

    public void showProgress(int resID) {
        showProgress(getResources().getString(resID));
    }

    @Override
    public void onPositiveButtonClicked(int requestCode) {
        if (requestCode == ConstantsRoseFashion.REQUEST_CODE_LOGIN) {
            ViewUtility.navigateIntoSignIn(getActivity());
        }
    }


/*/
/****************************************************************
/*/
/**************下面是一些最基本的使用AlertDialog逻辑处理*********
/*/
/****************************************************************

    */
/**
     * 此方法目前仅适用于标示ViewPager中的Fragment是否真实可见
     * For 友盟统计的页面线性不交叉统计需求
     *//*

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isCreated) {
            return;
        }
        if (isVisibleToUser) {
            MobclickAgent.onPageStart(getClass().getSimpleName());
        } else {
            MobclickAgent.onPageStart(getClass().getSimpleName());
        }
    }

    */
/**
     * 显示Progress Dialog
     *
     * @param strMessage Dialog里显示的内容
     *//*

    public void showProgress(String strMessage) {

        dialogFragment = ProgressDialogFragment.createBuilder(getActivity(), getFragmentManager())
                .setCancelableOnTouchOutside(false)
                .setMessage(strMessage)
                .show();
    }

    */
/**
     * 隐藏Progress Dialog
     *//*

    public void hideProgress() {
        try {
            if (dialogFragment != null) {
                dialogFragment.dismiss();
                dialogFragment = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCancelled(int requestCode) {

    }

    protected boolean couldUpdateUI() {
        return !isDestroyed && getActivity() != null && !getActivity().isDestroyed();
    }

    @Override
    public void onNegativeButtonClicked(int requestCode) {

    }

    @Override
    public void onNeutralButtonClicked(int requestCode) {

    }

    public void showAlertDialog(String title, String message) {
        showAlertDialog(title, message, ConstantsRoseFashion.DIALOG_FRAGMENT_REQUEST_CODE_DEFAULT);

    }

    public void showAlertDialog(String title, String message, int requestCode) {
        showAlertDialog(title, message, getString(R.string.ok), getString(R.string.cancel), requestCode);
    }


    public void showAlertDialog(@StringRes int title, @StringRes int message, @StringRes int positiveButton, @StringRes int negativeButton, int requestCode) {

        showAlertDialog(getString(title), getString(message), getString(positiveButton), getString(negativeButton), requestCode);
    }


    public void showAlertDialog(String title, String message, String positiveButton, String negativeButton, int requestCode) {
        SimpleDialogFragment.createBuilder(getActivity(), getFragmentManager())
                .setTargetFragment(this, requestCode)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButtonText(positiveButton)
                .setNegativeButtonText(negativeButton)
                .setTag(ConstantsRoseFashion.TAG_ALERT_DIALOG)
                .show();

    }

    */
/**
     * <p>方法详述（简单方法可不必详述）创建一个按钮的dialog</p>
     *//*

    public void showAlertDialog(String title, SpannableString message, String positiveButton, int requestCode) {
        SimpleDialogFragment.createBuilder(getActivity(), getFragmentManager())
                .setTargetFragment(this, requestCode)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButtonText(positiveButton)
                .setTag(ConstantsRoseFashion.TAG_ALERT_DIALOG)
                .show();
    }


    public void showAlertDialog(int titleResourceId, int messageResourceId) {
        showAlertDialog(getString(titleResourceId), getString(messageResourceId));
    }

    public void showAlertDialog(int titleResourceId, int messageResourceId, int requestCode) {
        showAlertDialog(getString(titleResourceId), getString(messageResourceId), requestCode);
    }

    @Override
    public void onDestroyView() {
        isDestroyed = true;
        compositeSubscription.unsubscribe();
        super.onDestroyView();
    }

    public CompositeSubscription getCompositeSubscription() {
        return compositeSubscription;
    }

    protected PostService getPostService() {
        return OFashionApplication.getInstance().getRestClient().getPostService();
    }

    protected AllService getAllService() {
        return OFashionApplication.getInstance().getRestClient().getAllService();
    }
/*/
/****************************************************************
/*/
/**************上面是一些最基本的使用AlertDialog逻辑处理*********
/*/

/****************************************************************

}
*/
/*
public class FindGoodsShopRecommendAdapter extends RecyclerView.Adapter<FindGoodsShopRecommendAdapter.RecommendBuyerViewHolder> {
    private Context context;
    private List<GoodsList> goods_list;
    private final LayoutInflater mLayoutInflater;


    public FindGoodsShopRecommendAdapter(Context context, List<GoodsList> goods_list) {
        this.goods_list = goods_list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public RecommendBuyerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendBuyerViewHolder(mLayoutInflater.inflate(R.layout.recycle_shop_buyer_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecommendBuyerViewHolder holder, int position) {
        if (AppUtils.isEmptyList(goods_list)) {
            return;
        }
        holder.tv_buyer_price.setText(AppUtils.getFormatPrice(goods_list.get(position).getGoods_price()));

        CoverImage coverImage = goods_list.get(position).getProduct_cover_image();
        if (coverImage != null && coverImage.getWidth() > 0 && coverImage.getWidth() > 0) {
            ImageUtils.loadImage(context, ImageUtils.constructImageUrlWebP240(coverImage.getPath()), holder.iv_recycle_shop_buyer_image);
        } else {
            holder.iv_recycle_shop_buyer_image.setImageResource(R.color.white);
        }

    }

    @Override
    public int getItemCount() {
        return goods_list == null ? 0 : goods_list.size();
    }


    public class RecommendBuyerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_recycle_shop_buyer_image)
        ImageView iv_recycle_shop_buyer_image;

        @BindView(R.id.tv_buyer_more)
        TextView tv_buyer_more;

        @BindView(R.id.tv_buyer_price)
        TextView tv_buyer_price;


        public RecommendBuyerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            AppUtils.isSetText(tv_buyer_price, AppUtils.getFormatPrice(Float.parseFloat(goods_list.get(0).getGoods_price_format())));
        }

    }
}*/
