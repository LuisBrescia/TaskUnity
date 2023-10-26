<template>
    <div class="card">
        <div class="img">
            <div class="save">
                <svg class="svg" width="683" height="683" viewBox="0 0 683 683" fill="none"
                    xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#clip0_993_25)">
                        <mask id="mask0_993_25" style="mask-type:luminance" maskUnits="userSpaceOnUse" x="0" y="0"
                            width="683" height="683">
                            <path d="M0 -0.00012207H682.667V682.667H0V-0.00012207Z" fill="white"></path>
                        </mask>
                        <g mask="url(#mask0_993_25)">
                            <path
                                d="M148.535 19.9999C137.179 19.9999 126.256 24.5092 118.223 32.5532C110.188 40.5866 105.689 51.4799 105.689 62.8439V633.382C105.689 649.556 118.757 662.667 134.931 662.667H135.039C143.715 662.667 151.961 659.218 158.067 653.09C186.451 624.728 270.212 540.966 304.809 506.434C314.449 496.741 327.623 491.289 341.335 491.289C355.045 491.289 368.22 496.741 377.859 506.434C412.563 541.074 496.752 625.242 524.816 653.348C530.813 659.314 538.845 662.667 547.308 662.667C563.697 662.667 576.979 649.395 576.979 633.019V62.8439C576.979 51.4799 572.48 40.5866 564.447 32.5532C556.412 24.5092 545.489 19.9999 534.133 19.9999H148.535Z"
                                stroke="#CED8DE" stroke-width="40" stroke-miterlimit="10" stroke-linecap="round"
                                stroke-linejoin="round"></path>
                        </g>
                    </g>
                    <defs>
                        <clipPath id="clip0_993_25">
                            <rect width="682.667" height="682.667" fill="white"></rect>
                        </clipPath>
                    </defs>
                </svg>
            </div>
        </div>

        <div class="text">
            <p class="p">
                <slot name="title">Default Description</slot>
            </p>
            <p class="p">
                <slot name="description">Default Description</slot>
            </p>

            <div class="icon-box">
                <svg viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M16.0497 8.44062C22.6378 3.32607 19.2566 0 19.2566 0C19.7598 5.28738 13.813 6.53583 12.2189 10.1692C11.1312 12.6485 12.9638 14.8193 16.0475 17.5554C15.7749 16.9494 15.3544 16.3606 14.9288 15.7645C13.4769 13.7313 11.9645 11.6132 16.0497 8.44062Z"
                        fill="#E76F00" />
                    <path
                        d="M17.1015 18.677C17.1015 18.677 19.0835 17.0779 17.5139 15.3008C12.1931 9.27186 23.3333 6.53583 23.3333 6.53583C16.5317 9.8125 17.5471 11.7574 19.2567 14.1202C21.0871 16.6538 17.1015 18.677 17.1015 18.677Z"
                        fill="#E76F00" />
                    <path
                        d="M22.937 23.4456C29.0423 20.3258 26.2195 17.3278 24.2492 17.7317C23.7662 17.8305 23.5509 17.9162 23.5509 17.9162C23.5509 17.9162 23.7302 17.64 24.0726 17.5204C27.9705 16.1729 30.9682 21.4949 22.8143 23.6028C22.8143 23.6029 22.9088 23.5198 22.937 23.4456Z"
                        fill="#5382A1" />
                    <path
                        d="M10.233 19.4969C6.41312 18.9953 12.3275 17.6139 12.3275 17.6139C12.3275 17.6139 10.0307 17.4616 7.20592 18.8043C3.86577 20.3932 15.4681 21.1158 21.474 19.5625C22.0984 19.1432 22.9614 18.7798 22.9614 18.7798C22.9614 18.7798 20.5037 19.2114 18.0561 19.4145C15.0612 19.6612 11.8459 19.7093 10.233 19.4969Z"
                        fill="#5382A1" />
                    <path
                        d="M11.6864 22.4758C9.55624 22.2592 10.951 21.2439 10.951 21.2439C5.43898 23.0429 14.0178 25.083 21.7199 22.8682C20.9012 22.5844 20.3806 22.0653 20.3806 22.0653C16.6163 22.7781 14.441 22.7553 11.6864 22.4758Z"
                        fill="#5382A1" />
                    <path
                        d="M12.6145 25.6991C10.486 25.4585 11.7295 24.7474 11.7295 24.7474C6.72594 26.1222 14.7729 28.9625 21.1433 26.2777C20.0999 25.8787 19.3528 25.4181 19.3528 25.4181C16.5111 25.9469 15.1931 25.9884 12.6145 25.6991Z"
                        fill="#5382A1" />
                    <path
                        d="M25.9387 27.3388C25.9387 27.3388 26.8589 28.0844 24.9252 28.6612C21.2481 29.7566 9.62093 30.0874 6.39094 28.7049C5.22984 28.2082 7.40723 27.5189 8.09215 27.3742C8.80646 27.2219 9.21466 27.2503 9.21466 27.2503C7.9234 26.3558 0.868489 29.0067 5.63111 29.7659C18.6195 31.8372 29.3077 28.8331 25.9387 27.3388Z"
                        fill="#5382A1" />
                    <path
                        d="M28 28.9679C27.7869 31.6947 18.7877 32.2683 12.9274 31.8994C9.10432 31.6583 8.33812 31.0558 8.32691 31.047C11.9859 31.6402 18.1549 31.7482 23.1568 30.8225C27.5903 30.0016 28 28.9679 28 28.9679Z"
                        fill="#5382A1" />
                </svg>
                <p class="span text-1xl font-semibold tracking-tighter">Development
                </p>
            </div>
        </div>
    </div>
</template>

<script setup>

const props = defineProps({
    linkParaProjeto: {
        type: String,
        default: '/desenvolvimento'
    }
})

</script>

<style scoped>
.card {
    width: 252px;
    height: 265px;
    background: white;
    border-radius: 24px;
    transition: 0.2s ease-in-out;
}

.card:hover {
    transform: translateY(-0.5rem);
}

.img {
    width: 100%;
    height: 50%;
    border-top-left-radius: 24px;
    border-top-right-radius: 24px;
    background: linear-gradient(#e66465, #9198e5);
    display: flex;
    align-items: top;
    justify-content: right;
}

.save {
    transition: 0.2s ease-in-out;
    border-radius: 10px;
    margin: 20px;
    width: 30px;
    height: 30px;
    background-color: #ffffff;
    display: flex;
    align-items: center;
    justify-content: center;
}

.text {
    margin: 20px;
    display: flex;
    flex-direction: column;
    align-items: space-around;
}

.save .svg {
    transition: 0.2s ease-in-out;
    width: 15px;
    height: 15px;
}

.icon-box {
    margin-top: 10px;
    margin-bottom: 15px;
    width: 70%;
    padding: 10px;
    background-color: #e3fff9;
    border-radius: 10px;
    display: flex;
    align-items: center;
    justify-content: left;
}

.icon-box svg {
    width: 17px;
}

.text .h3 {
    font-family: 'Lucida Sans' sans-serif;
    font-size: 15px;
    font-weight: 600;
    color: black;
}

.text .p {
    color: #292828;
    font-size: 13px;
}

.icon-box .span {
    margin-left: 10px;
    font-family: 'Lucida Sans' sans-serif;
    font-size: 13px;
    font-weight: 500;
    color: #9198e5;
}

.card:hover {
    cursor: pointer;
    box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
}

.save:hover {
    transform: scale(1.1) rotate(10deg);
}

.save:hover .svg {
    fill: #facc15;
}
</style>