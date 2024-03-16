SUMMARY = "Birdy Cam Cam image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "ssh-server-openssh"

CORE_IMAGE_EXTRA_INSTALL = " \
    autoreboot \
    motion \
"
