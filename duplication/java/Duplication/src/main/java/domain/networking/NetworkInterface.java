package domain.networking;

import java.net.Inet4Address;
import java.net.Inet6Address;

public class NetworkInterface {
    Inet4Address ipAddress;
    NetMask netMask;
    Inet4Address broadcast;
    Inet4Address defaultRoute;

    Inet6Address ipV6Address;
    NetMaskIpV6 ipV6NetMask;
    Inet6Address ipV6DefaultRoute;

    public NetworkInterface(Inet4Address ipAddress,
                            NetMask netMask,
                            Inet4Address broadcast,
                            Inet4Address defaultRoute) {
        this.ipAddress = ipAddress;
        this.netMask = netMask;
        this.broadcast = broadcast;
        this.defaultRoute = defaultRoute;
    }

    public NetworkInterface(Inet6Address ipV6Address,
                            NetMaskIpV6 ipV6NetMask,
                            Inet6Address ipV6DefaultRoute) {
        this.ipV6Address = ipV6Address;
        this.ipV6NetMask = ipV6NetMask;
        this.ipV6DefaultRoute = ipV6DefaultRoute;
    }

    public NetworkInterface(Inet4Address ipAddress,
                            NetMask netMask,
                            Inet4Address broadcast,
                            Inet4Address defaultRoute,
                            Inet6Address ipV6Address,
                            NetMaskIpV6 ipV6NetMask,
                            Inet6Address ipV6DefaultRoute) {
        this.ipAddress = ipAddress;
        this.netMask = netMask;
        this.broadcast = broadcast;
        this.defaultRoute = defaultRoute;
        this.ipV6Address = ipV6Address;
        this.ipV6NetMask = ipV6NetMask;
        this.ipV6DefaultRoute = ipV6DefaultRoute;
    }
}

