<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>

<%--<!DOCTYPE html>--%>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.0.2/tailwind.min.css">

    <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"/>

</head>
<body class="bg-[url('https://scontent.frak3-1.fna.fbcdn.net/v/t39.30808-6/307449188_406443081604461_362005879844723413_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=e3f864&_nc_eui2=AeGUTGvyWgdF_ayAg_4L5Jz_0pff7uCQJB3Sl9_u4JAkHSIHtv2uQfFKmvnCWIh5LKBmgh1FUyV1BPUemV_6CZ7S&_nc_ohc=WmKWborqtQoAX_A8YZM&_nc_zt=23&_nc_ht=scontent.frak3-1.fna&oh=00_AfArA1_Ti-orLxXcnUva2UR3uW69pJddMXg72Lrssr-6sQ&oe=63623E2F')]">


<section class="relative py-0  w-screen h-screen lg:py-20 bg-cover backdrop-blur-sm  ">


    <form action="/Auth" method="POST">

        <div class="flex flex-col items-center  justify-between  mx-auto max-w-7xl lg:flex-row  ">


            <%--        <div class="flex flex-col items-center w-full px-10 pt-5 pb-20 lg:pt-20 lg:flex-row">--%>
            <%--            <div class="relative w-full max-w-md bg-cover lg:max-w-2xl lg:w-7/12">--%>
            <%--                <div class="relative flex flex-col items-center justify-center w-full h-full lg:pr-10">--%>
            <%--                    <img src="https://jouvence.ma/wp-content/uploads/2016/07/marjane.png">--%>
            <%--&lt;%&ndash;                    <img src="https://dreammaroc.com/wp-content/uploads/2020/12/Sans-titre-1marjane-1.png">&ndash;%&gt;--%>
            <%--                </div>--%>
            <%--            </div>--%>

            <div class="relative   mx-auto w-full max-w-2xl mt-20 lg:mt-0 lg:w-5/12">
                <div class="relative z-10 flex flex-col items-start justify-start p-10 bg-white shadow-2xl rounded-xl">
                    <%--                    erreur message--%>

                    <c:if test="${error.size()!=0}">
                        <div class="bg-red-50 border-l-8 border-red-900 mb-2">
                            <div class="flex items-center">
                                <div class="p-2">
                                    <div class="flex items-center">
                                        <div class="ml-2">
                                            <svg class="h-8 w-8 text-red-900 mr-2 cursor-pointer"
                                                 xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                                 stroke="currentColor">
                                                <path stroke-linecap="round" stroke-linejoin="round"
                                                      stroke-width="2"
                                                      d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                                            </svg>
                                        </div>
                                        <p class="px-6 py-4 text-red-900 font-semibold text-lg">
                                            email ou le mot de pass est incorrect
                                        </p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:if>
                    <h4 class="w-full font-serif text-3xl my-2 font-medium leading-snug">Bonjour Admin!
                        </h4>


                    <div class="relative w-full mt-6 space-y-8">
                        <div class="relative">
                            <label class="absolute px-2 ml-2 -mt-3 font-medium text-gray-600 bg-white">Email
                            </label>
                            <input type="text"
                                   class="block w-full px-4 py-4 mt-2 text-base placeholder-gray-400 bg-white border border-gray-300 rounded-md focus:outline-none focus:border-black"
                                   placeholder="Email"
                                   name="email">

                        </div>
                        <div class="relative">
                            <label class="absolute px-2 ml-2 -mt-3 font-medium text-gray-600 bg-white">Mot De
                                Pass</label>
                            <input type="password"
                                   class="block w-full px-4 py-4 mt-2 text-base placeholder-gray-400 bg-white border border-gray-300 rounded-md focus:outline-none focus:border-black"
                                   placeholder="Mot De pass"
                                   name="pass">
                        </div>

                        <div class="relative">
                            <button
                                    type="submit"
                                    class="inline-block w-full px-5 py-4 text-xl font-medium text-center text-white transition duration-200 bg-blue-400 rounded-lg hover:bg-blue-600 ease">
                                Login

                            </button>


                        </div>


                    </div>


                </div>

            </div>

        </div>
    </form>
    </div>

</section>
</body>
</html>