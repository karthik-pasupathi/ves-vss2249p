SUMMARY = "OpenBMC for ves - Applications"
PR = "r1"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
        ${PN}-extras \
        ${PN}-fans \
        ${PN}-flash \
        ${PN}-system \
        "
PACKAGES:append:vs-withhost = " \
        ${PN}-chassis \
        ${PN}-hostmgmt \
        "

PROVIDES += "virtual/obmc-chassis-mgmt"
PROVIDES += "virtual/obmc-fan-mgmt"
PROVIDES += "virtual/obmc-flash-mgmt"
PROVIDES += "virtual/obmc-system-mgmt"

RPROVIDES:${PN}-chassis += "virtual-obmc-chassis-mgmt"
RPROVIDES:${PN}-fans += "virtual-obmc-fan-mgmt"
RPROVIDES:${PN}-flash += "virtual-obmc-flash-mgmt"
RPROVIDES:${PN}-system += "virtual-obmc-system-mgmt"

SUMMARY:${PN}-chassis = "ves Chassis"
RDEPENDS:${PN}-chassis = " \
        x86-power-control \
        "

SUMMARY:${PN}-extras:ves-vss2249p = "Extra features for ves"
RDEPENDS:${PN}-extras:ves-vss2249p = "phosphor-nvme"

SUMMARY:${PN}-fans = "ves Fans"
RDEPENDS:${PN}-fans = " \
        phosphor-pid-control \
        "

SUMMARY:${PN}-flash = "ves Flash"
RDEPENDS:${PN}-flash = " \
        phosphor-software-manager \
        "

RDEPENDS_PN_SYSTEM_EXTRAS = ""
RDEPENDS_PN_SYSTEM_EXTRAS:vs-withhost = " \
        phosphor-ipmi-ipmb \
        phosphor-hostlogger \
        phosphor-sel-logger \
        ipmitool \
        phosphor-post-code-manager \
        phosphor-host-postd \
        tzdata-core \
        "

SUMMARY:${PN}-system = "ves System"
RDEPENDS:${PN}-system = " \
        entity-manager \
        dbus-sensors \
        phosphor-virtual-sensor \
        ${RDEPENDS_PN_SYSTEM_EXTRAS} \
        "
