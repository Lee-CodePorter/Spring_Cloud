package top.leesh.fuse;

/**
 * @author 李书涵
 * @package_name: top.leesh.fuse
 * @createdate 2019/8/22 11:43
 */
public enum FuseType
{
    //开启状态  关闭状态    半开状态
    OPEN(0),CLOSE(1),HALF_OPEN(2);

    FuseType(int code)
    {

    }
}
